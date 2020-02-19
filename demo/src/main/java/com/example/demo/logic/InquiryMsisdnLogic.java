package com.example.demo.logic;

import org.springframework.stereotype.Controller;

import com.example.demo.request.InquiryMsisdnRequest;
import com.example.demo.response.InquiryMsisdnResponse;
import com.example.demo.response.ResponseFactory;

@Controller
public class InquiryMsisdnLogic extends BaseLogic<InquiryMsisdnResponse,InquiryMsisdnRequest>{

	@Override
	public InquiryMsisdnResponse process(InquiryMsisdnRequest request) {
		InquiryMsisdnResponse response = new InquiryMsisdnResponse();
		response.setDescription("Success for msisdn : "+request.getMsisdn());
		ResponseFactory.getSuccessfulResponse(response);
		return response;
	}
}
