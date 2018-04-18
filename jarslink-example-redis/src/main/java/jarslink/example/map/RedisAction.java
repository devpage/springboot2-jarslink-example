package jarslink.example.map;

import com.alipay.jarslink.api.Action;

import jarslink.example.api.ActionRequest;
import jarslink.example.api.DefaultCacheImpl;

public class RedisAction extends DefaultCacheImpl implements Action<ActionRequest, String>{

	private static final long serialVersionUID = 9219245460794102632L;

	public String execute(ActionRequest actionRequest) {
		return "redis:"+super.execute(actionRequest);
	}


	public String getActionName() {
		return "demoCache";
	}

}
