package org.sirma.model;

import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HREmployee extends BaseEmployee{
	private String specialty;

	public HREmployee(
		Long id, String name, LocalDate startDate, LocalDate endDate, Department department, EmployeeRole role,
		BigDecimal salary, String specialty) {
		super(id, name, startDate, endDate, department, role, salary);
		this.specialty = specialty;
	}

	public HREmployee(
		Long id, String name, Department department, EmployeeRole role, BigDecimal salary, String specialty) {
		super(id, name, department, role, salary);
		this.specialty = specialty;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "HREmployee{" +
		       "specialty='" + specialty + '\'' +
		       '}';
	}
}
