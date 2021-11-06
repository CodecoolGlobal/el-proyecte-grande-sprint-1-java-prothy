package com.codecool.javapeno.erp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ErpApplicationIntegrationTest {

	// if context does not load check if environment variables are set for test configs
	@Test
	void contextLoads(ApplicationContext context) {
		assertThat(context).isNotNull();
	}

}
