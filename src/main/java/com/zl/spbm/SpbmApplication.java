package com.zl.spbm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class SpbmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbmApplication.class, args);
	}
}
