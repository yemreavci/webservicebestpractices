package com.example.demo.logic;

import org.springframework.stereotype.Controller;

import com.example.demo.request.InquiryAccountRequest;
import com.example.demo.response.InquiryAccountResponse;
import com.example.demo.response.ResponseFactory;

@Controller
public class InquiryAccountLogic extends BaseLogic<InquiryAccountResponse,InquiryAccountRequest>{

	@Override
	public InquiryAccountResponse process(InquiryAccountRequest request) {
		InquiryAccountResponse response = new InquiryAccountResponse();
		response.setDescription("Success for msisdn : "+request.getAccount());
		ResponseFactory.getSuccessfulResponse(response);
		return response;
	}
}
