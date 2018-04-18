package jarslink.example.map;

import com.alipay.jarslink.api.Action;

import jarslink.example.api.ActionRequest;
import jarslink.example.api.DefaultCacheImpl;

public class MemoryAction extends DefaultCacheImpl implements Action<ActionRequest, String>{

	private static final long serialVersionUID = -63052827434556767L;

	public String execute(ActionRequest actionRequest) {
		return "memory:"+super.execute(actionRequest);
	}

	public String getActionName() {
		return "demoCache";
	}

 

}
