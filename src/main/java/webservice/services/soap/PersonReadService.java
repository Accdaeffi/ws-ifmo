package webservice.services.soap;

import java.util.List;
import java.util.Optional;

import javax.jws.WebService;
import javax.jws.WebMethod;

import webservice.database.model.Person;
import webservice.database.service.ReadService;

@WebService(serviceName = "PersonReadService")
public class PersonReadService {

	 @WebMethod(operationName = "getAllPersons")
	 public List<Person> getAllPersons() {
		 ReadService service = new ReadService();
		 return service.getAllPersons();
	 }
	 
	 @WebMethod(operationName = "getPersonById")
	 public Person getPersonById(int id) {
		 ReadService service = new ReadService();
		 
		 Optional<Person> optionalPerson = service.getById(id);
		 
		 if (optionalPerson.isPresent()) {
			 return optionalPerson.get();
		 } else {
			 return null;
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsByName")
	 public List<Person> getPersonsByName(String name) {
		 ReadService service = new ReadService();
		 
		 return service.getByName(name);
	 }
	 
	 @WebMethod(operationName = "getPersonsBySurname")
	 public List<Person> getPersonsBySurname(String surname) {
		 ReadService service = new ReadService();
		 
		 return service.getBySurname(surname);
	 }
	 
	 @WebMethod(operationName = "getPersonsByPatronymic")
	 public List<Person> getPersonsByPatronymic(String patronymic) {
		 ReadService service = new ReadService();
		 
		 return service.getByPatronymic(patronymic);
	 }
	 
	 @WebMethod(operationName = "getPersonsByAge")
	 public List<Person> getPersonsByAge(int age) {
		 ReadService service = new ReadService();
		 
		 return service.getByAge(age);
	 }
	 
	 @WebMethod(operationName = "getPersonsByNameAndSurname")
	 public List<Person> getPersonsByNameAndSurname(String name, String surname){
		 ReadService service = new ReadService();
		 
		 return service.getByNameAndSurname(name, surname);
	 }
	 
	 @WebMethod(operationName = "getPersonsByFullName")
	 public List<Person> getPersonsByFullName(String name, String surname, String patronymic){
		 ReadService service = new ReadService();
		 
		 return service.getByFullName(name, surname, patronymic);
	 }
	 
	 @WebMethod(operationName = "getPersonsYoungerThan")
	 public List<Person> getPersonsYoungerThan(int age) {
		 ReadService service = new ReadService();
		 
		 return service.getYoungerThan(age);
	 }
	 
	 @WebMethod(operationName = "getPersonsOlderThan")
	 public List<Person> getPersonsOlderThan(int age) {
		 ReadService service = new ReadService();
		 
		 return service.getOlderThan(age);
	 }
	 
}
