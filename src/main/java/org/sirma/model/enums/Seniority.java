package org.sirma.model.enums;

public enum Seniority {
	JUNIOR,
	MID,
	SENIOR,
	LEAD,
	PRINCIPAL;


	public static String getAll() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < Seniority.values().length; i++) {
			builder.append(i + 1).append(". ").append(Seniority.values()[i]).append(System.lineSeparator());
		}
		return builder.toString();
	}
}
