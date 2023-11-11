package org.sirma.mapper;

import org.sirma.exception.InvalidDataException;
import org.sirma.model.BaseEmployee;
import org.sirma.model.Developer;
import org.sirma.model.HREmployee;
import org.sirma.model.Manager;
import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;
import org.sirma.model.enums.ProgrammingLanguage;
import org.sirma.model.enums.Seniority;
import org.sirma.util.LocalDateFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeMapper implements Mapper<BaseEmployee> {

	@Override
	public BaseEmployee mapFromString(String line) {
		try {
			String[] params = line.split(",\\s+");
			Long id = Long.parseLong(params[0]);
			String name = params[1];
			LocalDate startDate = LocalDateFormatter.stringToLocalDate(params[2]);
			LocalDate endDate = params[3] != null ? LocalDateFormatter.stringToLocalDate(params[3]) : null;
			Department department = Department.valueOf(params[4]);
			EmployeeRole employeeRole = EmployeeRole.valueOf(params[5].toUpperCase());
			BigDecimal salary = new BigDecimal(params[6]);

			switch (params.length) {
				case 8 -> {
					String[] additionalDetails = params[7].split(":\\s+");
					switch (additionalDetails[0].toLowerCase()) {
						case "team" -> {
							List<String> teamNames = Arrays.stream(additionalDetails[1].split(" / ")).toList();
							return new Manager(id, name, startDate, endDate, department, employeeRole, salary, teamNames);
						}
						case "specialty" -> {
							String specialty = additionalDetails[1];
							return new HREmployee(id, name, startDate, endDate, department, employeeRole, salary, specialty);
						}
					}
				}
				case 9 -> {
					String seniority = params[7].split(":\\s+")[1];
					String technology = params[8].split(":\\s+")[1];
					return new Developer(id, name, startDate, endDate, department, employeeRole, salary,
					                     ProgrammingLanguage.valueOf(technology.toUpperCase()),
					                     Seniority.valueOf(seniority.toUpperCase()));
				}
			}
		}catch (Exception e){
			throw new InvalidDataException();
		}
		return null;
	}

	@Override
	public String mapToString(BaseEmployee employee) {
		StringBuilder builder = new StringBuilder();
		builder
			.append(employee.getId())
			.append(", ")
			.append(employee.getName())
			.append(", ")
			.append(employee.getStartDate())
			.append(", ")
			.append(employee.getEndDate())
			.append(", ")
			.append(employee.getDepartment().name())
			.append(", ")
			.append(employee.getRole().name())
			.append(", ")
			.append(employee.getSalary().toString());
		switch (employee.getRole()) {
			case DEVELOPER -> {
				Developer developer = (Developer) employee;
				builder
					.append(", ")
					.append("Seniority : ").append(developer.getSeniority().name())
					.append(", ")
					.append("Language: ").append(developer.getTechnology().name());
			}
			case MANAGER -> {
				Manager manager = (Manager) employee;
				builder.append(", ").append("Team: ");
				manager.getTeam().forEach(teamMemberName -> {
					builder.append(teamMemberName).append(" / ");
				});
			}
			case HR_REPRESENTATIVE -> {
				HREmployee hrEmployee = (HREmployee) employee;
				builder.append(", ").append("Specialty: ").append(hrEmployee.getSpecialty());
			}
		}
		return builder.toString();
	}
}
