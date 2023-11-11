package org.sirma.exception;

public class InvalidDataException extends RuntimeException{
	private static final String MESSAGE = "Invalid data. Please, check the validity in the file!";

	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
