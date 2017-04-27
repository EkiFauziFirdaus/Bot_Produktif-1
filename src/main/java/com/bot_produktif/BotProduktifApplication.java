package com.bot_produktif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class BotProduktifApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotProduktifApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello Java!";
	}
	
}
