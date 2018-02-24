package com.tienda.online.controller;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.dto.mensajes.ErrorResponse;
@RestController
public class BaseController {
	final static Logger logger = LoggerFactory.getLogger(BaseController.class); // logs
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse return404(NoSuchElementException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse return409(NoSuchElementException ex) {
		return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
	}
}
