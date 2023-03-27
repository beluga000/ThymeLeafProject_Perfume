package com.sist.perfume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.sist.perfume.entity","com.sist.perfume.dao","com.sist.perfume.controller","com.sist.perfume.rest"})
@SpringBootApplication
public class SpringBootJpaThymeleafProjectSunwooApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaThymeleafProjectSunwooApplication.class, args);
	}

}
