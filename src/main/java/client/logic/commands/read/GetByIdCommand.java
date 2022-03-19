package client.logic.commands.read;

import java.rmi.RemoteException;

import client.logic.commands.AbsCommand;
import client.logic.exceptions.IncorrectNumberOfArgumentsException;
import client.model.Person;
import client.model.faults.EmptyArgumentFault;
import client.model.faults.IncorrectArgumentFault;
import client.model.faults.PersonWithSuchIdNotFoundFault;
import client.model.faults.WorkWithSQLFault;
import client.service.read.PersonReadServiceProxy;

public class GetByIdCommand extends AbsCommand {

	private final int id;
	
	public GetByIdCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 1) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.id = Integer.parseInt(arguments[0]);
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonReadServiceProxy readProxy = new PersonReadServiceProxy();
		try {
			Person person = readProxy.getPersonById(id);
			
			if (person != null) {
				sb.append(person);
			} else {
				sb.append("Не найдено!");
			}
			
		} 
		catch (PersonWithSuchIdNotFoundFault e) {
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
