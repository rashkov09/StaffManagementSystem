package org.sirma.model.enums;

public enum Department {
	IT,
	HR;

	public static String getAll() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < Department.values().length; i++) {
			builder.append(i + 1).append(". ").append(Department.values()[i]).append(System.lineSeparator());
		}
		return builder.toString();
	}
}
