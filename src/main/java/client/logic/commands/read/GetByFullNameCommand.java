package client.logic.commands.read;

import java.rmi.RemoteException;

import client.logic.commands.AbsCommand;
import client.logic.exceptions.IncorrectNumberOfArgumentsException;
import client.model.Person;
import client.service.read.PersonReadServiceProxy;

public class GetByFullNameCommand extends AbsCommand {

	private final String name;
	private final String surname;
	private final String patronymic;

	public GetByFullNameCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 3) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.name = arguments[0].trim();
		this.surname = arguments[1].trim();
		this.patronymic = arguments[2].trim();
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonReadServiceProxy readProxy = new PersonReadServiceProxy();
		try {
			Person[] persons = readProxy.getPersonsByFullName(name, surname, patronymic);
			
			if (persons.length > 0) {
				for (Person p : persons) {
					sb.append(p.toString());
					sb.append("\n");
				}
			} else {
				sb.append("Не найдено!");
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
			sb.append("Ошибка соединения!");
		}
		
		return sb.toString();
	}
}
