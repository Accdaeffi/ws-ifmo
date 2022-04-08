package webservice.services.soap;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import webservice.database.model.Person;
import webservice.database.service.UpdateService;
import webservice.exceptions.EmptyArgumentException;
import webservice.exceptions.IncorrectArgumentException;
import webservice.exceptions.WorkWithSQLException;
import webservice.exceptions.faults.EmptyArgumentFault;
import webservice.exceptions.faults.IncorrectArgumentFault;
import webservice.exceptions.faults.WorkWithSQLFault;

@WebService(serviceName = "PersonUpdateService")
public class PersonUpdateService {

	@WebMethod(operationName = "updatePerson")
	public boolean updatePerson(Person person, String auth) 
			throws WorkWithSQLException, IncorrectArgumentException, EmptyArgumentException {
		 UpdateService service = new UpdateService();
		 
		 if (!auth.equals("Basic bG9naW46cGFzcw==")) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("login and/or password");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 if (person.getName() == null || person.getName().equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("name");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 if (person.getSurname() == null || person.getSurname().equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("surname");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 if (person.getPatronymic() == null || person.getPatronymic().equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("patronymic");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 if (person.getAge() < 0) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("age");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 try {
			return service.updatePerson(person);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
}
