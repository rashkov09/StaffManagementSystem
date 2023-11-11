package org.sirma.model.enums;

public enum EmployeeRole {
	MANAGER,
	DEVELOPER,
	HR_REPRESENTATIVE;

	public static String getAll() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < EmployeeRole.values().length; i++) {
			builder.append(i + 1).append(". ").append(EmployeeRole.values()[i]).append(System.lineSeparator());
		}
		return builder.toString();
	}


}
