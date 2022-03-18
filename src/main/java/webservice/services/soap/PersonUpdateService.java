package webservice.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import webservice.database.model.Person;
import webservice.database.service.UpdateService;

@WebService(serviceName = "PersonUpdateService")
public class PersonUpdateService {

	@WebMethod(operationName = "updatePerson")
	public boolean updatePerson(Person person) {
		 UpdateService service = new UpdateService();
		 
		 return service.updatePerson(person);
	 }
}
