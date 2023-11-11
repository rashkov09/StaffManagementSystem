package org.sirma.model.enums;

public enum ProgrammingLanguage {
	JAVA,
	PYTHON,
	JAVASCRIPT,
	C_SHARP,
	C_PLUS_PLUS,
	SWIFT,
	GO,
	RUST,
	TYPESCRIPT,
	KOTLIN;

	public static String getAll() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ProgrammingLanguage.values().length; i++) {
			builder.append(i + 1).append(". ").append(ProgrammingLanguage.values()[i]).append(System.lineSeparator());
		}
		return builder.toString();
	}
}
