package com.khadri.spring.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = Exception.class)
	public String handleAnyException() {
		return "exception";
	}

}
