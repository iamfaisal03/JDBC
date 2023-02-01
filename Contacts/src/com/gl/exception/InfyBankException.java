package com.gl.exception;

public class InfyBankException extends Exception {

	private String message;

	public InfyBankException() {
	}

	public InfyBankException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
