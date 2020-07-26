package org.sample.customermanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Spring Application
 * @author 이승호
 * @version 1.0
 *
 */
@SpringBootApplication
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class CustomermanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomermanagerApplication.class, args);
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner myCLRunner(){
		return new MyCLRunner();
	}

}
