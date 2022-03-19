package client.logic.commands.errors;

import client.logic.commands.AbsCommand;

public class NumberFormatCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		return "Неправильный формат аргументов!";
	}

}
