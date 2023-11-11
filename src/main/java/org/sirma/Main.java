package org.sirma;

import org.sirma.mapper.EmployeeMapper;
import org.sirma.mapper.Mapper;
import org.sirma.model.BaseEmployee;
import org.sirma.repository.EmployeeRepository;
import org.sirma.view.ConsoleView;
import org.sirma.view.MainView;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		Mapper<BaseEmployee> employeeMapper = new EmployeeMapper();
//			String line = sc.nextLine();
//			while (!line.equals("exit")){
//			BaseEmployee employee =	employeeMapper.mapFromString(line);
//			System.out.println(employee);
//				 line = sc.nextLine();
//			}
//
//		EmployeeRepository employeeRepository = new EmployeeRepository();
//		employeeRepository.getAllEmployees().forEach(System.out::println);
		ConsoleView consoleView = new MainView();
		consoleView.showMenu(consoleView);
	}
}