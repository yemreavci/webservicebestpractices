package com.example.demo.validator;

import org.springframework.stereotype.Controller;

import com.example.demo.exception.GeneralException;
import com.example.demo.request.InquiryAccountRequest;

@Controller
public class AccountValidator implements IRequestValidator{

	@Override
	public boolean validate(Object object) {
		String msisdn = String.valueOf(((InquiryAccountRequest)object).getAccount());
		if(isAccountNotExists(msisdn)) {
			throw new GeneralException("Account not found");
		}
		return true;
	}

	private boolean isAccountNotExists(String account) {
		return false;
	}

}
