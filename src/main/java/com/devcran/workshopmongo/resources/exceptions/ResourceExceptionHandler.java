package com.devcran.workshopmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devcran.workshopmongo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice // trata possiveis erros nas requisicoes
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest request) {
			
		StandardError standardError = new StandardError(
														System.currentTimeMillis(),
														HttpStatus.NOT_FOUND.value(),
														"Not found",
														e.getMessage(),
														request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}

}
