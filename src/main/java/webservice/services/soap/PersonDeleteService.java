package webservice.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import webservice.database.service.DeleteService;

@WebService(serviceName = "PersonDeleteService")
public class PersonDeleteService {

	@WebMethod(operationName = "deletePerson")
	public boolean deletePerson(int id) {
		 DeleteService service = new DeleteService();
		 
		 return service.deletePerson(id);
	 }
	
}
