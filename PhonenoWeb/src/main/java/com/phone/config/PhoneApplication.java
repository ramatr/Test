package com.phone.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan({"com.phone.controller","com.phone.service"})
@SpringBootApplication
public class PhoneApplication extends SpringBootServletInitializer implements WebApplicationInitializer{
	public static void main(String[] args) {
		SpringApplication.run(PhoneApplication.class, args);
	}
}
