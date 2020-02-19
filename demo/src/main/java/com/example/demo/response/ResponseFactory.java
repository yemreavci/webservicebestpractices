package com.example.demo.response;

import org.springframework.util.StringUtils;

import com.example.demo.constants.ResponseConstant;

public class ResponseFactory{

	public static <T extends BaseResponse> T getSuccessfulResponse(T response) {
		response.getHeader().setReturnType(ResponseConstant.RETURNTYPE_SUCCESS);
		response.getHeader().setReturnCode(ResponseConstant.RETURNCODE_SUCCESSFUL);
		response.getHeader().setReturnMessage(ResponseConstant.RETURN_SUCCESS_MSG);
		return response;
	}
	public static <T extends BaseResponse> T getMandatoryFieldFailResponse(T response, String message) {
		response.getHeader().setReturnType(ResponseConstant.RETURNTYPE_ERROR_PERMANENT);
		response.getHeader().setReturnCode(ResponseConstant.RETURNCODE_MANDATORY_FIELD_ERROR);
		response.getHeader().setReturnMessage(StringUtils.isEmpty(message) ? ResponseConstant.RETURN_FAIL_MSG : message);
		return response;
	}	

	public static <T extends BaseResponse> T getGeneralError(T response, String message) {
		response.getHeader().setReturnType(ResponseConstant.RETURNTYPE_ERROR_PERMANENT);
		response.getHeader().setReturnCode(ResponseConstant.RETURNCODE_GENERAL_ERROR);
		response.getHeader().setReturnMessage(message);
		return response;
	}	
}
