package jarslink.example.map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MySQLActionConfig {
	
	@Bean
	public MySQLAction getDemoAction() {
		return new MySQLAction();
	}
	
}