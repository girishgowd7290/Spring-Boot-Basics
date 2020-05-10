package com.codemads.springboot.basics;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * RestfulWebServicesApplication is a Spring Boot Initial Set up class
 * 
 * @author girishgowda
 *
 */

@SpringBootApplication
public class RestfulWebServicesApplication {

	/**
	 * Start up method of SpringApplication
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	/**
	 * SessionLocaleResolver makes the Default Locale - US
	 * 
	 * can u use AcceptHeaderLocaleResolver as well
	 * 
	 * @return
	 */
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	/**
	 * Can also be replaced by spring.messages.basename=messages in application.properties
	 * 
	 * @return
	 */
	@Bean
	public ResourceBundleMessageSource  messageSource() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
		return bundleMessageSource;
	}
}

