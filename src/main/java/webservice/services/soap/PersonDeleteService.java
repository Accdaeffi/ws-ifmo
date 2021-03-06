package webservice.services.soap;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import webservice.database.service.DeleteService;
import webservice.exceptions.*;
import webservice.exceptions.faults.IncorrectArgumentFault;
import webservice.exceptions.faults.WorkWithSQLFault;

@WebService(serviceName = "PersonDeleteService")
public class PersonDeleteService {

	@WebMethod(operationName = "deletePerson")
	public boolean deletePerson(int id) 
			throws WorkWithSQLException, IncorrectArgumentException {
		 DeleteService service = new DeleteService();
		 
		 if (id < 0) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("id");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 try {
			return service.deletePerson(id);
		} catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		}
	 }
	
}
