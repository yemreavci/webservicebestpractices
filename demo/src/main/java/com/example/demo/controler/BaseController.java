package com.example.demo.controler;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.BaseException;
import com.example.demo.logic.BaseLogic;
import com.example.demo.request.BaseRequest;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.ResponseFactory;
import com.example.demo.util.TransactionLogger;
import com.example.demo.validator.IRequestValidator;


public abstract class BaseController <T extends BaseRequest,K extends BaseResponse, M extends BaseLogic<K,T>>{
    private static Logger logger = Logger.getLogger(BaseController.class);
    @Autowired 
    private M logic;
    
    @Autowired
    private TransactionLogger<K, T> transactionLogger;
    
    public K process(T request, K response,List<IRequestValidator> validators) {
        long start = System.currentTimeMillis();
		logger.debug("Process method is called.");
        try {
        	request.validateMandatoryFields();
        	validatorsExecuter(request,validators);
        	response = logic.process(request);
        } catch (Exception e) {
            handleException(response, e);
        } finally {
            long end = System.currentTimeMillis();
            transactionLogger.write(request, end-start, response);
        }
        return response;
    }
    
    private void validatorsExecuter(T request, List<IRequestValidator> validators) {
    	for (IRequestValidator iRequestValidator : validators) {
			iRequestValidator.validate(request);
		}
	}

	public abstract K service(T request);
    
    public abstract List<IRequestValidator> validators();
    
  public void handleException(K response, Exception e) {
      if (e instanceof BaseException) {
          ((BaseException) e).getResponse(response);
          logger.error(e.getMessage(), e);
      }else {
          ResponseFactory.getGeneralError(response, e.toString());
          logger.error( e.getMessage(), e);
      }
  }
}
