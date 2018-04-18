package jarslink.example.map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryActionConfig {
	
	@Bean
	public MemoryAction getDemoAction() {
		return new MemoryAction();
	}
	
}