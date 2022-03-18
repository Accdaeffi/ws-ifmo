package client.model;

import java.util.ArrayList;

public class Base {
	
	private static Base instance;
	
	ArrayList<Person> database;
	
	private Base() {
		database = new ArrayList<Person>();
	}
	
	public static Base getBase() {
		if (instance == null) {
			instance = new Base();
		}
		
		return instance;
	}
	
	public void setBase(ArrayList<Person> persons) {
		database = persons;
	}
	
	public void printBase() {
		for (Person p : database) {
			System.out.println(p);
		}
	}

}
