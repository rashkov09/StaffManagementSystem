package org.sirma.view;

public enum Command {
	ADD("Add Employee"),
	EDIT("Edit"),
	LIST("List employees"),
	SEARCH("Search"),
	FIRE("Fire"),
	SAVE_AND_EXIT("Save & Exit");

	private final String commandName;

	Command(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName() {
		return commandName;
	}

	public static Command fromName(String commandName) {
		for (Command action : Command.values()) {
			if (action.getCommandName().equalsIgnoreCase(commandName)) {
				return action;
			}
		}
		throw new IllegalArgumentException("No command  with name: " + commandName);
	}

}
