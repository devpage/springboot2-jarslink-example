package jarslink.example.map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisActionConfig {

	@Bean
	public RedisAction getDemoAction() {
		return new RedisAction();
	}
	
}