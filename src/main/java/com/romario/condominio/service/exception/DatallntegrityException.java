package com.romario.condominio.service.exception;

public class DatallntegrityException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public DatallntegrityException (String msg) {
		super(msg);
	}
	
	public DatallntegrityException (String msg, Throwable cause) {
		super (msg, cause);
		
	}
	
}
