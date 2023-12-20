package com.aws.eureka.feign.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
 
       
        switch (response.status()){
	        case 400:
	        	log.error("Status code " + response.status() + ", methodKey = " + methodKey);
	            //handle exception
	            return new Exception("Bad Request Through Feign Exception");
	        case 401:
	            log.error("Error in request went through feign client");
	            //handle exception
	            return new Exception("Unauthorized Request Through Feign");
	        case 404:
	            log.error("Error in request went through feign client");
	            //handle exception
	            log.error("Error took place when using Feign client to send HTTP Request. Status code " + response.status() + ", methodKey = " + methodKey);
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Unidentified Request Through Feign Exception."); 
	        default:
	            log.error("Error in request went through feign client");
	            //handle exception
	            return new Exception("Common Feign Exception : " + response.reason());
        } 
    }

}