package org.sirma.exception;

public class FileNotFoundException extends RuntimeException{
	private static final String ERROR_MESSAGE = "File with path %s not found!";

	public FileNotFoundException(String path) {
		super(String.format(ERROR_MESSAGE,path));
	}
}
