package com.innocv.javaexercise.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * The handler for the errors in the application
 * @author Abraham Lominchar
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Method of the handler for the exception ResourceNOtFoundException
	 * @param ex The exception
	 * @param request The request
	 * @return The response
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

	/**
	 * Method of the handler for the exception Exception (global)
	 * @param ex The exception
	 * @param request The request
	 * @return The response
	 */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> glblExcptnHandler(Exception ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
   }
	
}
