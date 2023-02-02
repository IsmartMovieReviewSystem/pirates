package com.ismart.servicemovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc

public class ServicemovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicemovieApplication.class, args);
	}
}
