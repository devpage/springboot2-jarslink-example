package jarslink.example.jarslink;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.ModuleService;
import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import com.alipay.jarslink.api.impl.ModuleServiceImpl;

@Configuration
public class JarslinkConfig {
	
	@Bean
	public ModuleLoader moduleLoader() {
		return new ModuleLoaderImpl();
	}
	
	@Bean
	public ModuleManager moduleManager() {
		return new ModuleManagerImpl();
	}
	
	@Bean
	@DependsOn(value= {"moduleLoader","moduleManager"})
	public ModuleService moduleService(ModuleLoader moduleLoader, ModuleManager moduleManager) {
		ModuleServiceImpl moduleService = new ModuleServiceImpl();
		moduleService.setModuleLoader(moduleLoader);
		moduleService.setModuleManager(moduleManager);
		return moduleService;
	}
	
	@Bean
	@DependsOn(value= {"moduleService"})
	public ModuleRefreshSchedulerImpl moduleRefreshSchedulerImpl(ModuleLoader moduleLoader, ModuleManager moduleManager) {
		return new ModuleRefreshSchedulerImpl(moduleLoader, moduleManager);
	}
	
}