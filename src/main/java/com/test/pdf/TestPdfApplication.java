package com.test.pdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class TestPdfApplication {

	@Autowired
	private PdfService service;

	@Autowired
	private HtmlService htmlService;

	public static void main(String[] args) {
		SpringApplication.run(TestPdfApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

//			service.generatePdf();

//			System.out.println(htmlService.generateHtml());

			String test = htmlService.generateHtml();
			System.out.println("====================");
			System.out.println(test);
			System.out.println("====================");

			service.generatePdf(test);

		};
	}
}
