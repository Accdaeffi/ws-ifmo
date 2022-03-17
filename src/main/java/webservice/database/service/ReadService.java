package webservice.database.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import javax.sql.DataSource;

import webservice.database.ConnectionUtils;
import webservice.database.model.Person;

public class ReadService {

	private final Connection connection;

	public ReadService() {
		connection = ConnectionUtils.getConnection();
	}
	
	public ReadService(DataSource dataSource) throws SQLException {
		this.connection = dataSource.getConnection(); 
	}
	
	public Optional<Person> getById(int id) {
		Person result = null;
		
		String query = String.format("select * from person where id = %d;", id);
		ArrayList<Person> resultArray = executeQuery(query);
		
		if (resultArray.size()>0) {
			result = resultArray.get(0);
		}

		return Optional.ofNullable(result);
	}
	
	public ArrayList<Person> getAllPersons() {
		String query = String.format("select * from person;");
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getByName(String name) {
		String query = String.format("select * from person where name = '%s';", name);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getBySurname(String surname) {
		String query = String.format("select * from person where surname = '%s';", surname);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getByPatronymic(String patronymic) {
		String query = String.format("select * from person where patronymic = '%s';", patronymic);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getByAge(int age) {
		String query = String.format("select * from person where age = %d;", age);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getByNameAndSurname(String name, String surname) {
		String query = String.format("select * from person where name = '%s' and surname = '%s';", 
				name, surname);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getByFullName(String name, String surname, String patronymic) {
		String query = String.format("select * from person where name = '%s' and surname = '%s' and patronymic = '%s';",
				name, surname, patronymic);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getYoungerThan(int age) {
		String query = String.format("select * from person where age < %d;", age);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	public ArrayList<Person> getOlderThan(int age) {
		String query = String.format("select * from person where age > %d;", age);
		
		ArrayList<Person> result = executeQuery(query);

		return result;
	}
	
	
	private ArrayList<Person> executeQuery(String query) {
		ArrayList<Person> result = new ArrayList<>();
		
		try {	
			PreparedStatement statement = connection.prepareStatement(query);

			statement.execute();
			
			result = getAllPersonsFromResultSet(statement.getResultSet());
		}
		catch (SQLException ex) {
			//log.error("Error during extracting persons from database!");
		}
		
		return result;
	}
	
	
	
	private ArrayList<Person> getAllPersonsFromResultSet(ResultSet resultSet) throws SQLException {
		ArrayList<Person> result = new ArrayList<>();
		
		while (resultSet.next()) {
			Person per = new Person(resultSet.getInt("id"), 
					resultSet.getString("name"),
					resultSet.getString("surname"),
					resultSet.getString("patronymic"),
					resultSet.getInt("age"));	
			
			result.add(per);	
		}
		
		return result;
	}
	

	
	@Override
	protected void finalize() {
		try {
			connection.close();
		} catch (SQLException e) {
			// log.error("Error during closing of connection!");
			e.printStackTrace();
		}
	}
}
