package com.tchau.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TchauMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TchauMessageApplication.class, args);
	}

}
