package client.logic;

import java.util.ArrayList;

import client.logic.commands.AbsCommand;
import client.logic.commands.errors.*;
import client.model.Person;

public class CommandParser {

	private static CommandParser instance;
	
	ArrayList<Person> database;
	
	private CommandParser() {
		database = new ArrayList<Person>();
	}
	
	public static CommandParser getBase() {
		if (instance == null) {
			instance = new CommandParser();
		}
		
		return instance;
	}
	
	public AbsCommand parseMessage(String input) {
		String arr[] = input.split(" ", 2);
		String command = arr[0].trim();
		String arguments = (arr.length > 1) ? arr[1].trim() : null;

		AbsCommand commandHandler;
		
		switch (command) {
		
		
			default: {
				commandHandler = new UnknownCommand();
			}
			break;
		}
		
		return commandHandler;
	}

}
