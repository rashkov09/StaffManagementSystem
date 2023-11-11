package org.sirma.service;

import org.sirma.model.BaseEmployee;
import org.sirma.model.Developer;
import org.sirma.model.HREmployee;
import org.sirma.model.Manager;
import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;
import org.sirma.model.enums.ProgrammingLanguage;
import org.sirma.model.enums.Seniority;
import org.sirma.repository.EmployeeRepository;
import org.sirma.util.ConsoleRangeReader;
import org.sirma.util.ConsoleReader;

import java.math.BigDecimal;

public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService() {
		this.employeeRepository = new EmployeeRepository();
	}

	public void addEmployee(String employeeData) {
		BaseEmployee employee = null;
		try {
			String[] data = employeeData.split(",\\s+");
			Long id = Long.parseLong(data[0]);
			String name = data[1];

			Department department = Department.valueOf(data[2].toUpperCase());
			EmployeeRole employeeRole = EmployeeRole.valueOf(data[3].toUpperCase());
			BigDecimal salary = new BigDecimal(data[4]);
			switch (employeeRole) {
				case DEVELOPER -> {
					System.out.println("Please, choose language and seniority: ");
					System.out.println("Available languages: ");
					System.out.println(ProgrammingLanguage.getAll());
					int languageChoice = ConsoleRangeReader.readInt(0, ProgrammingLanguage.values().length) - 1;
					System.out.println("Available seniority: ");
					System.out.println(Seniority.getAll());
					int seniorityChoice = ConsoleRangeReader.readInt(0, Seniority.values().length) - 1;
					employee =
						new Developer(id, name, department, employeeRole, salary, ProgrammingLanguage.values()[languageChoice],
						              Seniority.values()[seniorityChoice]);
				}
				case MANAGER -> {
					employee = new Manager(id, name, department, employeeRole, salary);
				}
				case HR_REPRESENTATIVE -> {
					System.out.println("Please, insert HR specialty:");
					String specialty = ConsoleReader.readString();
					employee = new HREmployee(id, name, department, employeeRole, salary, specialty);
				}
			}
			if (employee != null) {
				employeeRepository.addEmployee(employee);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean saveData() {
		try {
			employeeRepository.save();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void init() {
		employeeRepository.loadData();
	}

	public String getAllEmployees() {
		StringBuilder builder = new StringBuilder();
		employeeRepository.getAllEmployees().forEach(employee -> builder.append(employee.toString()).append(System.lineSeparator()));
		return builder.toString();
	}

	public String getEmployeeById(int id) {
		return employeeRepository.getEmployeeById(Long.parseLong(String.valueOf(id))).toString();
	}
}
