package org.dnyanyog.exception;

import java.util.Map;

import org.dnyanyog.dto.PatientRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandling { 
	 @ExceptionHandler(ResourceNotFoundException.class)
	   public  ResponseEntity<PatientRequest> ResourceNotFoundExceptionHandler() { 
		   return new ResponseEntity(Map.of("message" , "911") , HttpStatus.NOT_FOUND) ;  
		     
		    
	   }


}
