package com.romario.condominio.service.exception;

public class ObjectNotFoundexception extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundexception (String msg) {
		super(msg);
	}
	
	public ObjectNotFoundexception (String msg, Throwable cause) {
		super (msg, cause);
		
	}
	
}
