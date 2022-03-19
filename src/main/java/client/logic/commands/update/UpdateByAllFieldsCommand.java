package client.logic.commands.update;

import java.rmi.RemoteException;

import client.logic.commands.AbsCommand;
import client.logic.exceptions.IncorrectNumberOfArgumentsException;
import client.model.Person;
import client.service.update.PersonUpdateServiceProxy;

public class UpdateByAllFieldsCommand extends AbsCommand {

	private final Person personToUpdate;
	
	public UpdateByAllFieldsCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 5) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		int id = Integer.parseInt(arguments[0]);
		String name = arguments[1].trim();
		String surname = arguments[2].trim();
		String patronymic = arguments[3].trim();
		int age = Integer.parseInt(arguments[4]);
		
		personToUpdate = new Person(id, name, surname, patronymic, age);
	}
	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonUpdateServiceProxy updateProxy = new PersonUpdateServiceProxy();
		try {
			boolean result = updateProxy.updatePerson(personToUpdate);
			if (result) {
				sb.append("Обновлено успешно!");
			} else {
				sb.append("Ошибка обновления!");
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			sb.append("Ошибка соединения!");
		}
		
		return sb.toString();
	}

}
