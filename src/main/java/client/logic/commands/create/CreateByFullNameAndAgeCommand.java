package client.logic.commands.create;

import java.rmi.RemoteException;

import client.logic.BasicAuthStringGenerator;
import client.logic.commands.AbsCommand;
import client.logic.exceptions.IncorrectNumberOfArgumentsException;
import client.model.Person;
import client.model.faults.EmptyArgumentFault;
import client.model.faults.IncorrectArgumentFault;
import client.model.faults.WorkWithSQLFault;
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
					personToAdd.getAge(),
					BasicAuthStringGenerator.generateString());
			
			sb.append(String.format("Успешно добавлено! Id нового объект - %d.", result.getId())); 
		}
		catch (IncorrectArgumentFault | EmptyArgumentFault e) {
			sb.append(e.getFaultString());
		}
		catch (WorkWithSQLFault e) {
			sb.append("Ошибка при работе с SQL! ");
			sb.append(e.getFaultString());
		}
		catch (RemoteException e) {
			e.printStackTrace();
			sb.append("Ошибка соединения!");
		}
		
		return sb.toString();
	}

}
