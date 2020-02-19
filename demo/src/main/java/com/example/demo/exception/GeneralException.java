package com.example.demo.exception;

import com.example.demo.response.BaseResponse;
import com.example.demo.response.ResponseFactory;

public class GeneralException  extends BaseException{

	private static final long serialVersionUID = 1919841752143370073L;
	public GeneralException(String message) {
		this.setMessage(message);
	}
	@Override
	public <T extends BaseResponse> T getResponse(T responseDto) {
		return ResponseFactory.getGeneralError(responseDto, getMessage());
	}

}
