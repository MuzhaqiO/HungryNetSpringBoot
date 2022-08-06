package com.hungerNet.Hunger.Net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HungerNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HungerNetApplication.class, args);
	}

}
