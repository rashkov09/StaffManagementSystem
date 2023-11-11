package org.sirma.model;

import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;

import java.time.LocalDate;

public abstract class AbstractEmployee {
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Department department;
	private EmployeeRole role;

	public AbstractEmployee(
		String name, LocalDate startDate, LocalDate endDate, Department department, EmployeeRole role) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.department = department;
		this.role = role;
	}

	public AbstractEmployee(String name, Department department, EmployeeRole role) {
		this.name = name;
		this.startDate = LocalDate.now();
		this.endDate = null;
		this.department = department;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AbstractEmployee{" +
		       "name='" + name + '\'' +
		       ", startDate=" + startDate +
		       ", endDate=" + endDate +
		       ", department=" + department +
		       ", role=" + role +
		       '}';
	}
}
