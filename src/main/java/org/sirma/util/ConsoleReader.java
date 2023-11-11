package org.sirma.util;

import java.util.Scanner;

public class ConsoleReader {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String INVALID_INT = "%s is not a number. Try again: ";
	private ConsoleReader() {
		throw new UnsupportedOperationException();
	}

	public static String readString() {
		String line = scanner.nextLine();
		if (line == null || line.isEmpty()){
			line = scanner.nextLine();
			System.out.println("Invalid input! Cannot be empty!");
		}
		return line;
	}

	public static int readInt() {
		while (!scanner.hasNextInt()) {
			String input = scanner.next();
			System.out.printf(INVALID_INT, input);
		}
		int input = scanner.nextInt();
		scanner.nextLine();
		return input;
	}
}
