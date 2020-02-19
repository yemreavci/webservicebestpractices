package com.example.demo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.example.demo.constants.Constants;
import com.example.demo.request.BaseRequest;
import com.example.demo.response.BaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Controller
public class TransactionLogger <T extends BaseResponse,M extends BaseRequest> {
    private static final Logger logger = Logger.getLogger("TransactionLogger");
    public  void write(M request, long duration, T response) {
    	StringBuilder logStr = new StringBuilder();
        logStr.append("duration : "+duration+"\n");
        logStr.append("request : ");
        logStr.append(toJsonRequest(request));
        logStr.append("response : ");
        logStr.append(toJsonResponse(response));
        logger.fatal(logStr);
    }
    private String toJsonResponse(T responseDto) {
        String jsonResponse = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            DateFormat dateFormat=new SimpleDateFormat(Constants.ITI_DATE_FORMAT);
            jsonResponse = mapper.enable(SerializationFeature.INDENT_OUTPUT).setDateFormat(dateFormat).writeValueAsString(responseDto);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        return jsonResponse;
    }
    private String toJsonRequest(M request) {
        String jsonResponse = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            DateFormat dateFormat=new SimpleDateFormat(Constants.ITI_DATE_FORMAT);
            jsonResponse = mapper.enable(SerializationFeature.INDENT_OUTPUT).setDateFormat(dateFormat).writeValueAsString(request);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        return jsonResponse;
    }   

}
