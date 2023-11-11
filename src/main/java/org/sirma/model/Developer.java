package org.sirma.model;

import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;
import org.sirma.model.enums.ProgrammingLanguage;
import org.sirma.model.enums.Seniority;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Developer extends BaseEmployee{
	private ProgrammingLanguage technology;
	private Seniority seniority;

	public Developer(
		Long id, String name, LocalDate startDate, LocalDate endDate, Department department, EmployeeRole role,
		BigDecimal salary, ProgrammingLanguage technology, Seniority seniority) {
		super(id, name, startDate, endDate, department, role, salary);
		this.technology = technology;
		this.seniority = seniority;
	}

	public Developer(
		Long id, String name, Department department, EmployeeRole role, BigDecimal salary, ProgrammingLanguage technology,
		Seniority seniority) {
		super(id, name, department, role, salary);
		this.technology = technology;
		this.seniority = seniority;
	}

	public ProgrammingLanguage getTechnology() {
		return technology;
	}

	public void setTechnology(ProgrammingLanguage technology) {
		this.technology = technology;
	}

	public Seniority getSeniority() {
		return seniority;
	}

	public void setSeniority(Seniority seniority) {
		this.seniority = seniority;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() +
		       "Developer{" +
		       "technology=" + technology +
		       ", seniority=" + seniority +
		       '}';
	}
}
