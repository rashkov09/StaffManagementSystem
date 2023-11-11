package org.sirma.model;

import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends BaseEmployee{
	private List<String> team;

	public Manager(
		Long id, String name, LocalDate startDate, LocalDate endDate, Department department, EmployeeRole role,
		BigDecimal salary, List<String> team) {
		super(id, name, startDate, endDate, department, role, salary);
		this.team = team;
	}

	public Manager(
		Long id, String name, Department department, EmployeeRole role, BigDecimal salary) {
		super(id, name, department, role, salary);
		this.team = new ArrayList<>();
	}

	public List<String> getTeam() {
		return team;
	}

	public void setTeam(List<String> team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Manager{" +
		       "team=" + team +
		       '}';
	}
}
