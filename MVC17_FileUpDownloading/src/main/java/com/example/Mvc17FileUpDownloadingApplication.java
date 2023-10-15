package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class Mvc17FileUpDownloadingApplication {

	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver createResolver() {
		return  new StandardServletMultipartResolver();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Mvc17FileUpDownloadingApplication.class, args);
	}

}
