package com.sud.fsbd.exceptionHandler;

public class RecordNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String msg) {
		super(msg);
	}
	
	public RecordNotFoundException() {
		super();
	}
}
