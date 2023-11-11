package org.sirma.view;

import org.sirma.model.enums.Department;
import org.sirma.model.enums.EmployeeRole;
import org.sirma.service.EmployeeService;
import org.sirma.util.ConsoleReader;

import static java.lang.System.exit;

public class MainView implements ConsoleView {

	private final EmployeeService employeeService = new EmployeeService();
	private static final String MAIN_MESSAGE = """
                                            
	                                           <--- Welcome to Staff Management System ---> 
	                                                                                       
	                                           Please, insert one of the available commands: 
	                                            Add Employee -> Add a new employee
	                                            Edit [employee id] -> Edit employee information using ID
	                                            List employees -> List all employees
	                                            Search -> Navigate to Search menu
	                                            Fire -> Fire an employee
	                                                                                       
	                                           0. Save & Exit -> Writes information and closes the app
	                                           """;

	@Override
	public void showMenu(ConsoleView invoker) {
		employeeService.init();
		System.out.println(MAIN_MESSAGE);
		String commandInput = ConsoleReader.readString();
		try {
			while (!Command.fromName(commandInput).equals(Command.SAVE_AND_EXIT)) {
				switch (Command.fromName(commandInput)) {
					case ADD -> {
						System.out.println("Available departments: ");
						System.out.println(Department.getAll());
						System.out.println("Available roles: ");
						System.out.println(EmployeeRole.getAll());
						System.out.println(""" 
     Please, insert information in the following way:
     
     id, full name, department, employee role, salary
    
     """);
						String employeeData = ConsoleReader.readString();
						employeeService.addEmployee(employeeData);
					}
					case EDIT -> {
						System.out.println("This is edit command");
					}
					case LIST -> {
						System.out.println(employeeService.getAllEmployees());
					}
					case SEARCH -> {
						System.out.println("Enter id:");
						int id = ConsoleReader.readInt();
						System.out.println(employeeService.getEmployeeById(id));
					}
					case FIRE -> {
						System.out.println("This is fire command");
					}

					default -> System.out.println("Invalid command");
				}
				System.out.println(MAIN_MESSAGE);
				commandInput = ConsoleReader.readString();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.showMenu(this);
		}
		if (employeeService.saveData()){
			exit(1);
		};
		this.showMenu(this);
	}
}
