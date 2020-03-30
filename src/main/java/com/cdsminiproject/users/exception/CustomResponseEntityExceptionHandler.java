package com.cdsminiproject.users.exception;

import com.cdsminiproject.users.dto.response.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.InvalidUserCsvException.class)
	public final ResponseEntity handleInvalidUserCsvException(Exception ex, WebRequest request) {
		Response response = Response.badRequest().setError(ex.getMessage());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		Response response = Response.badRequest().setError(fieldErrors.get(0).getDefaultMessage());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}
}
