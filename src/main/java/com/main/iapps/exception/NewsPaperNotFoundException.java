package com.main.iapps.exception;

public class NewsPaperNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NewsPaperNotFoundException(String message) {
		super(message);
	}

	public NewsPaperNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NewsPaperNotFoundException(Throwable cause) {
		super(cause);
	}
}
