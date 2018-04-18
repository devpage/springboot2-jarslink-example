package jarslink.example.api;

import java.util.HashMap;

public class DefaultCacheImpl extends HashMap<String, String>{

	private static final long serialVersionUID = 1856176994820250618L;

	protected String execute(ActionRequest actionRequest) {
		String result = null;
		switch (actionRequest.getOpt()) {
		case 0:
			result = put(actionRequest.getKey(), actionRequest.getValue());
			break;
		default:
			result = get(actionRequest.getKey());
			break;
		}
		return result;
	}
	
}