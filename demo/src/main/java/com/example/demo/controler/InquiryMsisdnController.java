package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logic.InquiryMsisdnLogic;
import com.example.demo.request.InquiryMsisdnRequest;
import com.example.demo.response.InquiryMsisdnResponse;
import com.example.demo.validator.IRequestValidator;
import com.example.demo.validator.MsisdnValidator;

@RestController
@RequestMapping("demo")
public class InquiryMsisdnController extends BaseController<InquiryMsisdnRequest,InquiryMsisdnResponse,InquiryMsisdnLogic>{
	@Autowired
	MsisdnValidator msisdnValidator;
	@Override
    @PostMapping(value = "/inquiry/msisdn")
	public @ResponseBody InquiryMsisdnResponse service(@RequestBody InquiryMsisdnRequest request) {
		InquiryMsisdnResponse response= new InquiryMsisdnResponse();
    	return process(request,response,validators());
	}

	@Override
	public List<IRequestValidator> validators() {
		List<IRequestValidator> validators= new ArrayList<IRequestValidator>();
		validators.add(msisdnValidator);
		return validators;
	}
}
