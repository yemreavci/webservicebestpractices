package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logic.InquiryAccountLogic;
import com.example.demo.request.InquiryAccountRequest;
import com.example.demo.response.InquiryAccountResponse;
import com.example.demo.validator.AccountValidator;
import com.example.demo.validator.IRequestValidator;

@RestController
@RequestMapping("demo")
public class InquiryAccountController extends BaseController<InquiryAccountRequest,InquiryAccountResponse,InquiryAccountLogic>{

	@Autowired
	AccountValidator accountValidator;
	@Override
    @PostMapping(value = "/inquiry/account")
	public InquiryAccountResponse service(InquiryAccountRequest request) {
		InquiryAccountResponse response = new InquiryAccountResponse();
    	return process(request,response ,validators());
	}

	@Override
	public List<IRequestValidator> validators() {
		List<IRequestValidator> validators= new ArrayList<IRequestValidator>();
		validators.add(accountValidator);
		return validators;
	}

}
