package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration config;

    public void sendEmail(User user, Map<String, Object> model) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            String subject = "Welcome to Javapeño";
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Template t = config.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            helper.setFrom("javapeno2021@gmail.com");
            helper.setTo(user.getEmail());
            helper.setSubject(subject);
            helper.setText(html, true);

            mailSender.send(message);

        } catch (MessagingException | IOException | TemplateException e) {
            System.out.println("Mail Sending failure : " + e.getMessage());
        }
    }

    public void sendEmail(User user) {
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        sendEmail(user, model);
    }
}