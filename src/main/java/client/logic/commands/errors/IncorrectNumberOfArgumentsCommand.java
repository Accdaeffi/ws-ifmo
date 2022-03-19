package client.logic.commands.errors;

import client.logic.commands.AbsCommand;

public class IncorrectNumberOfArgumentsCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		return "Неправильное количество аргументов!";
	}

}
