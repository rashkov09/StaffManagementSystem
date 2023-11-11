package org.sirma.model;

import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BaseEmployee extends AbstractEmployee implements Employee{
	private Long id;
	private BigDecimal salary;

	public BaseEmployee(
		Long id, String name, LocalDate startDate, LocalDate endDate, Department department, EmployeeRole role,
		BigDecimal salary) {
		super(name, startDate, endDate, department, role);
		this.id = id;
		this.salary = salary;
	}

	public BaseEmployee(Long id, String name, Department department, EmployeeRole role, BigDecimal salary) {
		super(name, department, role);
		this.id = id;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "BaseEmployee{" +
		       "id=" + id +
		       ", salary=" + salary +
		       '}';
	}
}
