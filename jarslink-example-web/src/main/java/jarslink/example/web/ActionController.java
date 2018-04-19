package jarslink.example.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.ModuleService;

import jarslink.example.api.ActionRequest;
import jarslink.example.jarslink.ModuleRefreshSchedulerImpl;

@RestController
@RequestMapping("action")
public class ActionController {
	
	@Resource(name = "moduleManager")
	private ModuleManager moduleManager;
	@Resource(name = "moduleService")
	private ModuleService moduleService;
	
	@RequestMapping(value = "/set/{key}/{val}", method = RequestMethod.GET)
	@ResponseBody
	public Object set(@PathVariable("key") String key,@PathVariable("val") String val) {
		// 查找服务
		Module findModule = moduleManager.find("demo-cache-service");
		// 得到具体模块
		Action<ActionRequest, String> action = findModule.getAction("demoCache");
		ActionRequest req = new ActionRequest();
		req.setOpt(0);
		req.setKey(key);
		req.setValue(val);
		// 执行Action，数据交互
		String orderString = action.execute(req);
		return orderString;
	}
	
	@RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable("key") String key) {
		Module findModule = moduleManager.find("demo-cache-service");
		Action<ActionRequest, String> action = findModule.getAction("demoCache");
		ActionRequest req = new ActionRequest();
		req.setOpt(1);
		req.setKey(key);
		String orderString = action.execute(req);
		return orderString;
	}
	
	@RequestMapping(value = "/reload/{module}/{version}", method = RequestMethod.GET)
	@ResponseBody
	public Object reloadModule(@PathVariable("module") String module,@PathVariable("version") String version) {
		ModuleConfig moduleConfig = ModuleRefreshSchedulerImpl.buildModuleConfig(module, version);
		moduleConfig.setEnabled(true);
		moduleService.loadAndRegister(moduleConfig);
		return "success";
	}
	
}