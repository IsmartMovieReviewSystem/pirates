package com.ismart.servicemovie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{
	
	public MovieNotFoundException(String msg) {
		super(msg);
	}
}