package webservice.services.soap;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import webservice.database.model.Person;
import webservice.database.service.CreateService;
import webservice.exceptions.*;
import webservice.exceptions.faults.EmptyArgumentFault;
import webservice.exceptions.faults.IncorrectArgumentFault;
import webservice.exceptions.faults.WorkWithSQLFault;

@WebService(serviceName = "PersonCreateService")
public class PersonCreateService {

	@WebMethod(operationName = "createPerson")
	public Person createPerson(String name, String surname, String patronymic, int age, String auth) 
			throws IncorrectArgumentException, EmptyArgumentException, WorkWithSQLException {
		 CreateService service = new CreateService();
		 
		 if (!auth.equals("Basic bG9naW46cGFzcw==")) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("login and/or password");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 if (age < 0) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("age");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 if (name == null || name.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("name");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 if (surname == null || surname.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("surname");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 if (patronymic == null || patronymic.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("patronymic");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 Person person = new Person(name, surname, patronymic, age);
		 
		 try {
			return service.createPerson(person);
		} catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		}
	 }
	
}
