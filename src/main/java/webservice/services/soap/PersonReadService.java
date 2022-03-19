package webservice.services.soap;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.jws.WebService;
import javax.jws.WebMethod;

import webservice.database.model.Person;
import webservice.database.service.ReadService;
import webservice.exceptions.EmptyArgumentException;
import webservice.exceptions.IncorrectArgumentException;
import webservice.exceptions.PersonWithSuchIdNotFoundException;
import webservice.exceptions.WorkWithSQLException;
import webservice.exceptions.faults.EmptyArgumentFault;
import webservice.exceptions.faults.IncorrectArgumentFault;
import webservice.exceptions.faults.PersonWithSuchIdNotFoundFault;
import webservice.exceptions.faults.WorkWithSQLFault;

@WebService(serviceName = "PersonReadService")
public class PersonReadService {

	 @WebMethod(operationName = "getAllPersons")
	 public List<Person> getAllPersons() 
			 throws WorkWithSQLException {
		 
		 ReadService service = new ReadService();
		 try {
			return service.getAllPersons();
		} catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		}
	 }
	 
	 @WebMethod(operationName = "getPersonById")
	 public Person getPersonById(int id) 
			 throws WorkWithSQLException, PersonWithSuchIdNotFoundException {
		 ReadService service = new ReadService();
		 
		 Optional<Person> optionalPerson;
		 try {
			 optionalPerson = service.getById(id);

		 
		 if (optionalPerson.isPresent()) {
			 return optionalPerson.get();
		 } else {
			 PersonWithSuchIdNotFoundFault fault = new PersonWithSuchIdNotFoundFault(id);
			 throw new PersonWithSuchIdNotFoundException(fault);
		 }
		 } catch (SQLException e) {
			 e.printStackTrace();
			 WorkWithSQLFault fault = new WorkWithSQLFault();
			 throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
		 
	 }
	 
	 @WebMethod(operationName = "getPersonsByName")
	 public List<Person> getPersonsByName(String name) 
			 throws WorkWithSQLException, EmptyArgumentException {
		 ReadService service = new ReadService();
		 
		 if (name == null || name.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("name");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 try {
			return service.getByName(name);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsBySurname")
	 public List<Person> getPersonsBySurname(String surname) 
			 throws WorkWithSQLException, EmptyArgumentException {
		 ReadService service = new ReadService();
		 
		 if (surname == null || surname.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("surname");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 try {
			return service.getBySurname(surname);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsByPatronymic")
	 public List<Person> getPersonsByPatronymic(String patronymic) 
			 throws WorkWithSQLException, EmptyArgumentException {
		 ReadService service = new ReadService();
		 
		 if (patronymic == null || patronymic.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("patronymic");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 try {
			return service.getByPatronymic(patronymic);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsByAge")
	 public List<Person> getPersonsByAge(int age) 
			 throws WorkWithSQLException, IncorrectArgumentException {
		 if (age < 0) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("age");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 ReadService service = new ReadService();
		 
		 try {
			return service.getByAge(age);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsByNameAndSurname")
	 public List<Person> getPersonsByNameAndSurname(String name, String surname) 
			 throws WorkWithSQLException, EmptyArgumentException{
		 ReadService service = new ReadService();
		 
		 if (name == null || name.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("name");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 if (surname == null || surname.equals("")) {
			 EmptyArgumentFault fault = new EmptyArgumentFault("surname");
			 throw new EmptyArgumentException(fault);
		 }
		 
		 try {
			return service.getByNameAndSurname(name, surname);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsByFullName")
	 public List<Person> getPersonsByFullName(String name, String surname, String patronymic) 
			 throws WorkWithSQLException, EmptyArgumentException{
		 ReadService service = new ReadService();
		 
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
		 
		 try {
			return service.getByFullName(name, surname, patronymic);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsYoungerThan")
	 public List<Person> getPersonsYoungerThan(int age) 
			 throws WorkWithSQLException, IncorrectArgumentException {
		 
		 if (age < 0) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("age");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 ReadService service = new ReadService();
		 
		 try {
			return service.getYoungerThan(age);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
	 @WebMethod(operationName = "getPersonsOlderThan")
	 public List<Person> getPersonsOlderThan(int age) 
			 throws WorkWithSQLException, IncorrectArgumentException {
		 
		 if (age < 0) {
			 IncorrectArgumentFault fault = new IncorrectArgumentFault("age");
			 throw new IncorrectArgumentException(fault);
		 }
		 
		 ReadService service = new ReadService();
		 
		 try {
			return service.getOlderThan(age);
		 } catch (SQLException e) {
			e.printStackTrace();
			WorkWithSQLFault fault = new WorkWithSQLFault();
			throw new WorkWithSQLException(e.getMessage(), fault, e);
		 }
	 }
	 
}
