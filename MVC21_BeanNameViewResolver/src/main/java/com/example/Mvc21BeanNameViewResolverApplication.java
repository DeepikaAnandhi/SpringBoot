package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class Mvc21BeanNameViewResolverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mvc21BeanNameViewResolverApplication.class, args);
	}
	
	
	@Bean
	public BeanNameViewResolver createViewResolver() {
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return viewResolver;
		
	}

}
