package com.example.demo.response;

public class BaseResponse {
	private ResponseHeader header;

	public BaseResponse() {

	}

	public ResponseHeader getHeader() {
		if(header == null) {
			header= new ResponseHeader();
		}
		return header;
	}

	public void setHeader(ResponseHeader header) {
		this.header = header;
	}
}
