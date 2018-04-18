package jarslink.example.jarslink;

import java.net.URL;
import java.util.List;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;


public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {
	
	public ModuleRefreshSchedulerImpl(ModuleLoader moduleLoader, ModuleManager moduleManager) {
		super.setModuleLoader(moduleLoader);
		super.setModuleManager(moduleManager);
	}
	
	@Override
	public List<ModuleConfig> queryModuleConfigs() {
		return ImmutableList.of(buildModuleConfig());
	}

	public static ModuleConfig buildModuleConfig() {
		URL demoModule = Thread.currentThread().getContextClassLoader().getResource("META-INF/jarslink-example-memory-0.0.1.jar");
		ModuleConfig moduleConfig = new ModuleConfig();
		moduleConfig.setName("demo-cache-service");
		moduleConfig.setEnabled(true);
		moduleConfig.setVersion(String.valueOf(System.currentTimeMillis()));
		moduleConfig.setProperties(ImmutableMap.of("author", "songjian"));
		moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
		moduleConfig.addScanPackage("jarslink.example.map");
		return moduleConfig;
	}
	
	public static ModuleConfig buildModuleConfig(String module,String version) {
		URL demoModule = Thread.currentThread().getContextClassLoader().getResource(String.format("META-INF/%s-%s.jar", module, version));
		ModuleConfig moduleConfig = new ModuleConfig();
		moduleConfig.setName("demo-cache-service");
		moduleConfig.setEnabled(true);
		moduleConfig.setVersion(String.valueOf(System.currentTimeMillis()));
		moduleConfig.setProperties(ImmutableMap.of("author", "songjian", "desc", "runtime loading functions"));
		moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
		moduleConfig.addScanPackage("jarslink.example.map");
		return moduleConfig;
	}

}