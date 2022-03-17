package webservice.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	
	int id;
	String name;
	String surname;
	String patronymic;
	int age;

}
