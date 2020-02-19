package com.example.demo.request;

import org.springframework.util.StringUtils;

import com.example.demo.exception.MandatoryParameterException;

public class InquiryMsisdnRequest extends BaseRequest{
	private String msisdn;
	@Override
	public void validateMandatoryFields() {
		if(StringUtils.isEmpty(getHeader().getPassword())) {
			throw new MandatoryParameterException("Password can not be null!");
		}else if(StringUtils.isEmpty(getHeader().getUserName())) {
			throw new MandatoryParameterException("Username can not be null!");
		}else if(StringUtils.isEmpty(msisdn)) {
			throw new MandatoryParameterException("Msisdn can not be null!");			
		}
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
}
