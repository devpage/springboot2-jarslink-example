package jarslink.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="jarslink.example")
public class PlayJarsLink {

	public static void main(String[] args) {
		SpringApplication.run(PlayJarsLink.class, args);
	}
	
}