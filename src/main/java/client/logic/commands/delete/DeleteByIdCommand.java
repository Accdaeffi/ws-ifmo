package client.logic.commands.delete;

import java.rmi.RemoteException;

import client.logic.BasicAuthStringGenerator;
import client.logic.commands.AbsCommand;
import client.logic.exceptions.IncorrectNumberOfArgumentsException;
import client.model.faults.IncorrectArgumentFault;
import client.model.faults.WorkWithSQLFault;
import client.service.delete.PersonDeleteServiceProxy;

public class DeleteByIdCommand extends AbsCommand {

	private final int id;
	
	public DeleteByIdCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 1) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.id = Integer.parseInt(arguments[0]);
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonDeleteServiceProxy deleteProxy = new PersonDeleteServiceProxy();
		try {
			boolean result = deleteProxy.deletePerson(id, BasicAuthStringGenerator.generateString());
			if (result) {
				sb.append("Удалено успешно!");
			} else {
				sb.append("Ошибка удаления!");
			}
		} 
		catch (IncorrectArgumentFault e) {
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
