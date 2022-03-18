package webservice.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import webservice.database.model.Person;
import webservice.database.service.CreateService;

@WebService(serviceName = "PersonCreateService")
public class PersonCreateService {

	@WebMethod(operationName = "createPerson")
	public Person createPerson(String name, String surname, String patronymic, int age) {
		 CreateService service = new CreateService();
		 
		 Person person = new Person(name, surname, patronymic, age);
		 
		 return service.createPerson(person);
	 }
	
}
