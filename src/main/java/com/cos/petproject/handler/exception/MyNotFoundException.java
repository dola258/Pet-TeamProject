package com.cos.petproject.handler.exception;

public class MyNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MyNotFoundException(String msg) {
		super(msg);
	}
}
