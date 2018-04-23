package jarslink.example.api;

import java.io.Serializable;

public class GatewayResponse<T> implements Serializable {

	private static final long serialVersionUID = -2692047411017703120L;
	/**
	 * 接口调用成功，不需要返回对象
	 */
	public static <T> GatewayResponse<T> newSuccess(){
		GatewayResponse<T> GatewayResponse = new GatewayResponse<T>();
		return GatewayResponse;
	}
	
	/**
	 * 接口调用成功，有返回对象
	 */
	public static <T> GatewayResponse<T> newSuccess(T object) {
		GatewayResponse<T> GatewayResponse = new GatewayResponse<T>();
		GatewayResponse.setObject(object);
		return GatewayResponse;
	}
	
	/**
	 * 接口调用失败，有错误码和描述，没有返回对象
	 */
	public static <T> GatewayResponse<T> newFailure(int code, String message){
		GatewayResponse<T> GatewayResponse = new GatewayResponse<T>();
		GatewayResponse.setCode(code!=0 ? code : -1);
		GatewayResponse.setMessage(message);
		return GatewayResponse;
	}
	
	/**
	 * 接口调用失败，有错误字符串码和描述，没有返回对象
	 */
	public static <T> GatewayResponse<T> newFailure(String error, String message){
		GatewayResponse<T> GatewayResponse = new GatewayResponse<T>();
		GatewayResponse.setCode(-1);
		GatewayResponse.setError(error);
		GatewayResponse.setMessage(message);
		return GatewayResponse;
	}
	
	/**
	 * 转换或复制错误结果
	 */
	public static <T> GatewayResponse<T> newFailure(GatewayResponse<?> failure){
		GatewayResponse<T> GatewayResponse = new GatewayResponse<T>();
		GatewayResponse.setCode(failure.getCode()!=0 ? failure.getCode() : -1);
		GatewayResponse.setError(failure.getError());
		GatewayResponse.setMessage(failure.getMessage());
		GatewayResponse.setException(failure.getException());
		return GatewayResponse;
	}
	
	/**
	 * 接口调用失败，返回异常信息
	 */
	public static <T> GatewayResponse<T> newException(Exception e){
		GatewayResponse<T> GatewayResponse = new GatewayResponse<T>();
		GatewayResponse.setCode(-1);
		GatewayResponse.setException(e);
		GatewayResponse.setMessage(e.getMessage());
		return GatewayResponse;
	}
	
	private int code;
	private T object;
	private String error;
	private String message;
	private Exception exception;
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
}