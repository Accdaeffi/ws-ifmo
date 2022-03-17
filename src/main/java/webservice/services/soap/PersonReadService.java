package webservice.services.soap;

import java.util.List;

import javax.jws.WebService;
import javax.jws.WebMethod;

import webservice.database.model.Person;
import webservice.database.service.ReadService;

@WebService(serviceName = "PersonReadService")
public class PersonReadService {

	 @WebMethod(operationName = "getAllPersons")
	 public List<Person> getPersons() {
		 ReadService service = new ReadService();
		 return service.getAllPersons();
	 }
}
