package com.codecool.javapeno.erp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and()
                .csrf().disable()

                .authorizeRequests()
                    .antMatchers("/api/login/**", "/api/logout/**", "/api/auth-service/**").permitAll()
                    .antMatchers("/api/transaction/**").hasAnyAuthority("SUPER_USER", "ADMIN", "USER")
                    .antMatchers("/api/user/add").hasAnyAuthority("SUPER_USER", "ADMIN")
                    .antMatchers("/api/user/**").hasAnyAuthority("USER")
                    .antMatchers("/api/**").hasAnyAuthority("SUPER_USER", "ADMIN")
                    .anyRequest().authenticated().and()

                .exceptionHandling()
                    .authenticationEntryPoint(new Http403ForbiddenEntryPoint()).and()

                .formLogin().loginProcessingUrl("/api/login")
                    .successHandler(new SuccessHandler())
                    .failureHandler((request, response, authentication) -> response.setStatus(401)).and()

                .logout().logoutUrl("/api/logout")
                    .logoutSuccessHandler((request, response, authentication) -> response.setStatus(200))
                    .invalidateHttpSession(true).deleteCookies("JSESSIONID").and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();

        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    static class SuccessHandler implements AuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
            User user = (User) authentication.getPrincipal();
            request.getSession().setAttribute("username", user.getUsername());

            response.setStatus(200);
        }
    }
}
