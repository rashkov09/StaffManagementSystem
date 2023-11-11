package org.sirma.accessor.csv;

import org.sirma.accessor.Accessor;
import org.sirma.exception.FileNotFoundException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.sirma.constant.Paths.EMPLOYEE_CSV_FILE_PATH;

public class CSVAccessor implements Accessor {

	@Override
	public List<String> read() {
		try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_CSV_FILE_PATH))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			throw new FileNotFoundException(EMPLOYEE_CSV_FILE_PATH);
		}
	}

	@Override
	public void write(List<String> lines) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(EMPLOYEE_CSV_FILE_PATH, false))) {
			lines.forEach(line -> {
				try {
					writer.write(line+"\n");
				} catch (IOException e) {
					throw new FileNotFoundException(EMPLOYEE_CSV_FILE_PATH);
				}
			});
		} catch (IOException e) {
			throw new FileNotFoundException(EMPLOYEE_CSV_FILE_PATH);
		}
	}
}
