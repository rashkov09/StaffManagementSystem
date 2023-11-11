package org.sirma;

import org.sirma.view.ConsoleView;
import org.sirma.view.MainView;

public class Main {

	public static void main(String[] args) {
		ConsoleView consoleView = new MainView();
		consoleView.showMenu(consoleView);
	}
}