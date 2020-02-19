package com.example.demo.exception;

import com.example.demo.response.BaseResponse;

public abstract class BaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

	public abstract  <T extends BaseResponse> T getResponse(T response);

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
