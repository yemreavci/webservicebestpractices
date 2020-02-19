package com.example.demo.request;

public abstract class BaseRequest {
	private RequestHeader header;
	public abstract void validateMandatoryFields();
	public RequestHeader getHeader() {
		return header;
	}
	public void setHeader(RequestHeader header) {
		this.header = header;
	}		
}