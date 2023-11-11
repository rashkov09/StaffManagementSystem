package org.sirma.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
	private static final String MESSAGE = "Employee with id %s already exists!";

	public EmployeeAlreadyExistsException(String id) {
		super(String.format(MESSAGE,id));
	}
}
