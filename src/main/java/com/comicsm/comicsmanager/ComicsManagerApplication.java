package com.comicsm.comicsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ComicsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicsManagerApplication.class, args);
	}
}
