package com.example.demo.request;

import org.springframework.util.StringUtils;

import com.example.demo.exception.MandatoryParameterException;

public class InquiryAccountRequest extends BaseRequest{
	private String account;
	@Override
	public void validateMandatoryFields() {
		if(StringUtils.isEmpty(getHeader().getPassword())) {
			throw new MandatoryParameterException("Password can not be null!");
		}else if(StringUtils.isEmpty(getHeader().getUserName())) {
			throw new MandatoryParameterException("Username can not be null!");
		}else if(StringUtils.isEmpty(account)) {
			throw new MandatoryParameterException("Msisdn can not be null!");			
		}
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}