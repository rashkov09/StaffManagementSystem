package org.sirma.util;

import java.time.LocalDate;

public final class LocalDateFormatter {
	public static LocalDate stringToLocalDate(String initial) {
		if (initial.equals("null")){
			return null;
		}
		String[] dateValues = initial.split("-");
		return LocalDate.of(Integer.parseInt(dateValues[0]), Integer.parseInt(dateValues[1]), Integer.parseInt(dateValues[2]));
	}

	public static String localDateToString(LocalDate date) {
		return String.format("%s-%s-%s",date.getYear(), date.getMonthValue(), date.getDayOfMonth());
	}
}
