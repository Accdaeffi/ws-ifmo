package client.logic.commands.create;

import java.rmi.RemoteException;

import client.logic.commands.AbsCommand;
import client.logic.exceptions.IncorrectNumberOfArgumentsException;
import client.model.Person;
import client.service.create.PersonCreateServiceProxy;

public class CreateByFullNameAndAgeCommand extends AbsCommand {

	private final Person personToAdd;
	
	public CreateByFullNameAndAgeCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 4) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		String name = arguments[0].trim();
		String surname = arguments[1].trim();
		String patronymic = arguments[2].trim();
		int age = Integer.parseInt(arguments[3]);
		
		personToAdd = new Person(name, surname, patronymic, age);
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonCreateServiceProxy createProxy = new PersonCreateServiceProxy();
		try {
			Person result = createProxy.createPerson(personToAdd.getName(), 
					personToAdd.getSurname(), 
					personToAdd.getPatronymic(), 
					personToAdd.getAge());
			
			sb.append(String.format("Успешно добавлено! Id нового объект - %d.", result.getId()));
		} catch (RemoteException e) {
			e.printStackTrace();
			sb.append("Ошибка соединения!");
		}
		
		return sb.toString();
	}

}
