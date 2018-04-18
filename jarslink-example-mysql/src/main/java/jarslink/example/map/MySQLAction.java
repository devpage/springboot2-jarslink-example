package jarslink.example.map;

import com.alipay.jarslink.api.Action;

import jarslink.example.api.ActionRequest;
import jarslink.example.api.DefaultCacheImpl;

public class MySQLAction extends DefaultCacheImpl implements Action<ActionRequest, String>{
	
	private static final long serialVersionUID = -4716239074103927075L;

	public String execute(ActionRequest actionRequest) {
		return "mysql:"+super.execute(actionRequest);
	}

	public String getActionName() {
		return "demoCache";
	}

}
