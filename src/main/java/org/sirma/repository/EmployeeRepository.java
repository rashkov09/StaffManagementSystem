package org.sirma.repository;

import org.sirma.accessor.Accessor;
import org.sirma.accessor.csv.CSVAccessor;
import org.sirma.exception.EmployeeAlreadyExistsException;
import org.sirma.mapper.EmployeeMapper;
import org.sirma.mapper.Mapper;
import org.sirma.model.BaseEmployee;
import org.sirma.model.enums.Department;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository {

	private final LinkedHashMap<Long, BaseEmployee> employees;
	private final Accessor csvAccessor = new CSVAccessor();
	private final Mapper<BaseEmployee> employeeMapper = new EmployeeMapper();

	public EmployeeRepository() {
		this.employees = new LinkedHashMap<>();
	}

	public void loadData() {
		csvAccessor.read().stream().map(employeeMapper::mapFromString).forEach(employee -> {
			employees.put(employee.getId(), employee);
		});
	}

	public List<BaseEmployee> getAllEmployees() {
		return employees.values().stream().toList();
	}

	public BaseEmployee getEmployeeById(Long id) {
		return employees.get(id);
	}

	public List<BaseEmployee> getEmployeeByName(String name) {
		return employees.values().stream().filter(employee -> employee.getName().equals(name)).collect(Collectors.toList());
	}

	public List<BaseEmployee> getEmployeeByDepartment(Department department) {
		return employees.values().stream().filter(employee -> employee.getDepartment().equals(department)).collect(
			Collectors.toList());
	}

	public void addEmployee(BaseEmployee employee) {
		if (employees.containsKey(employee.getId())) {
			throw new EmployeeAlreadyExistsException(employee.getId().toString());
		}
		employees.put(employee.getId(), employee);
		System.out.println("Added");
	}

	public void save() {
		try {
			List<String> lines = employees.values().stream().map(employeeMapper::mapToString).toList();
			csvAccessor.write(lines);

			System.out.println("Data saved");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
