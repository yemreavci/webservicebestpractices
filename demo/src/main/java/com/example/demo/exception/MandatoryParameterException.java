package com.example.demo.exception;

import com.example.demo.response.BaseResponse;
import com.example.demo.response.ResponseFactory;

public class MandatoryParameterException  extends BaseException{

	private static final long serialVersionUID = 1919841752143370073L;
	public MandatoryParameterException(String message) {
		this.setMessage(message);
	}
	@Override
	public <T extends BaseResponse> T getResponse(T responseDto) {
		return ResponseFactory.getMandatoryFieldFailResponse(responseDto, getMessage());
	}

}
