package client;

import java.rmi.RemoteException;

import client.service.create.PersonCreateServiceProxy;
import client.service.delete.PersonDeleteServiceProxy;
import client.model.Person;
import client.service.read.PersonReadServiceProxy;
import client.service.update.PersonUpdateServiceProxy;

public class Main {

	public static void main(String[] args) {
		int size = 0;
	
		PersonReadServiceProxy readProxy = new PersonReadServiceProxy();
		try {
			Person[] persons = readProxy.getAllPersons();
			for (Person p : persons) {
				System.out.println(p.getId() + " " + p.getName());
			}
			
			size = persons.length;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Person person = new Person();
		person.setAge(30);
		person.setName("Ivan");
		person.setSurname("Ivanov");
		person.setPatronymic("Ivanovich");
		
		
		PersonCreateServiceProxy createProxy = new PersonCreateServiceProxy();
		try {
			person.setId(createProxy.createPerson("Ivan", "Ivanov", "Ivanovich", 30).getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Person[] persons = readProxy.getAllPersons();

			if (size+1 == persons.length) {
				System.out.println("Really added!");
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		person.setName("Petr");
		
		System.out.println("Started updating!");
		
		PersonUpdateServiceProxy updateProxy = new PersonUpdateServiceProxy();
		try {
			updateProxy.updatePerson(person);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			person = readProxy.getPersonById(person.getId());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println("Starting deleting!");
		
		PersonDeleteServiceProxy deleteProxy = new PersonDeleteServiceProxy();
		try {
			deleteProxy.deletePerson(person.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Person[] persons = readProxy.getAllPersons();

			if (size == persons.length) {
				System.out.println("Really deleted!");
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
