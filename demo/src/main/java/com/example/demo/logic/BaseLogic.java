package com.example.demo.logic;

import com.example.demo.request.BaseRequest;
import com.example.demo.response.BaseResponse;

public abstract class BaseLogic <T extends BaseResponse, S extends BaseRequest>{
	public abstract T process(S request);
}