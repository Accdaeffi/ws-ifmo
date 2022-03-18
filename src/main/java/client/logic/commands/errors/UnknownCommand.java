package client.logic.commands.errors;

import client.logic.commands.AbsCommand;

public class UnknownCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		return "Неизвестная команда!";
	}

}
