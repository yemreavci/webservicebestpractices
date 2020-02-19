package com.example.demo.validator;

import org.springframework.stereotype.Controller;

import com.example.demo.exception.GeneralException;
import com.example.demo.request.InquiryMsisdnRequest;

@Controller
public class MsisdnValidator implements IRequestValidator{

	@Override
	public boolean validate(Object object) {
		String msisdn = String.valueOf(((InquiryMsisdnRequest)object).getMsisdn());
		if(isSubcriberNotExists(msisdn)) {
			throw new GeneralException("Subscriber not found");
		}
		return true;
	}

	private boolean isSubcriberNotExists(String msisdn) {
		return false;
	}
}
