package client.logic.commands.read;

import java.rmi.RemoteException;

import client.logic.commands.AbsCommand;
import client.model.Person;
import client.model.faults.EmptyArgumentFault;
import client.model.faults.IncorrectArgumentFault;
import client.model.faults.WorkWithSQLFault;
import client.service.read.PersonReadServiceProxy;

public class GetAllCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonReadServiceProxy readProxy = new PersonReadServiceProxy();
		try {
			Person[] persons = readProxy.getAllPersons();
			
			if (persons != null) {
				for (Person p : persons) {
					sb.append(p.toString());
					sb.append("\n");
				}
			} else {
				sb.append("Не найдено!");
			}
			
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
