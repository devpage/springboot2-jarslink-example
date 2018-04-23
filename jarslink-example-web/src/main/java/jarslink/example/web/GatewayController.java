package jarslink.example.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleManager;

import jarslink.example.api.GatewayResponse;

@RestController
public class GatewayController {

	@Resource(name = "moduleManager")
	private ModuleManager moduleManager;	
	
	@RequestMapping(value = "gateway/{moduleName}/{actionName}", method = {RequestMethod.GET, RequestMethod.POST})
	public GatewayResponse<?> process(HttpServletRequest request, HttpServletResponse response,@SuppressWarnings("rawtypes") @RequestBody Map requestBody) {  
	    Map < String, String > pathVariables = resolvePathVariables(request);  
	    String moduleName = pathVariables.get("moduleName").toUpperCase();
	    String actionName = pathVariables.get("actionName").toUpperCase(); 
	    Module findModule = moduleManager.find(moduleName);
		@SuppressWarnings("rawtypes")
		Action<Map, String> action = findModule.getAction(actionName);
		try {
			return GatewayResponse.newSuccess(action.execute(requestBody));
		} catch (Exception e) {
			return GatewayResponse.newException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> resolvePathVariables(HttpServletRequest request) {
		return (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
	}

}