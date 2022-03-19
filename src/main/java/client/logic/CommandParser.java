package client.logic;

import java.util.ArrayList;

import client.logic.commands.AbsCommand;
import client.logic.commands.create.*;
import client.logic.commands.delete.*;
import client.logic.commands.errors.*;
import client.logic.commands.read.*;
import client.logic.commands.update.*;
import client.logic.exceptions.*;

public class CommandParser {

	private static CommandParser instance;
	
	private CommandParser() {
	}
	
	public static CommandParser getParser() {
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
		
		try {
			switch (command) {
				case "/getAll": {
					commandHandler = new GetAllCommand();
				}
				break;
				case "/getByAge": {
					commandHandler = new GetByAgeCommand(arguments);
				}
				break;
				case "/getByFullName": {
					commandHandler = new GetByFullNameCommand(arguments);
				}
				break;
				case "/getById": {
					commandHandler = new GetByIdCommand(arguments);
				}
				break;
				case "/getByNameAndSurname": {
					commandHandler = new GetByNameAndSurnameCommand(arguments);
				}
				break;
				case "/getByName": {
					commandHandler = new GetByNameCommand(arguments);
				}
				break;
				case "/getByPatronymic": {
					commandHandler = new GetByPatronymicCommand(arguments);
				}
				break;
				case "/getBySurname": {
					commandHandler = new GetBySurnameCommand(arguments);
				}
				break;
				case "/getOlderThan": {
					commandHandler = new GetOlderThanCommand(arguments);
				}
				break;
				case "/getYoungerThan": {
					commandHandler = new GetYoungerThanCommand(arguments);
				}
				break;
				
				case "/create": {
					commandHandler = new CreateByFullNameAndAgeCommand(arguments);
				}
				break;
				
				case "/deleteById": {
					commandHandler = new DeleteByIdCommand(arguments);
				}
				break;
				
				case "/update": {
					commandHandler = new UpdateByAllFieldsCommand(arguments);
				}
				break;
			
				default: {
					commandHandler = new UnknownCommand();
				}
				break;
			}
		}
		catch (IncorrectNumberOfArgumentsException ex) {
			commandHandler = new IncorrectNumberOfArgumentsCommand();
		}
		catch (NumberFormatException ex) {
			commandHandler = new NumberFormatCommand();
		}
		
		return commandHandler;
	}

}
