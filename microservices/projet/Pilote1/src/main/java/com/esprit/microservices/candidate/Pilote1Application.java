package com.esprit.microservices.candidate;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class Pilote1Application {

	public static void main(String[] args) {
		SpringApplication.run(Pilote1Application.class, args);
	}
	
	 @Bean
	    ApplicationRunner init(Pilote1Repository repository) {
	        return args -> {
	            Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
	                repository.save(new Pilote1(nom));
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	    }

}
