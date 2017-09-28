package com.imagestore.util;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	private Object data;
	private String message;
	private int errorCode;

	public ApiResponse() {
	}

	/**
	 * @param msg
	 * @param obj
	 * @return ResponseDto
	 */
	public static ApiResponse successResponse(String msg, Object obj) {
		ApiResponse sucess = new ApiResponse();
		sucess.setMessage(msg);
		sucess.setData(obj);
		sucess.setErrorCode(HttpStatus.OK.value());
		return sucess;
	}

	/**
	 * @param msg
	 * @param obj
	 * @return ResponseDto
	 */
	public static ApiResponse failureResponse(String msg, Object obj, int errorCode) {
		ApiResponse failure = new ApiResponse();
		failure.setMessage(msg);
		failure.setData(obj);
		failure.setErrorCode(errorCode);
		return failure;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
