package webservice.database.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import webservice.database.ConnectionUtils;
import webservice.database.model.Person;

public class CreateService {
	
	private final Connection connection;

	public CreateService() {
		connection = ConnectionUtils.getConnection();
	}
	
	public CreateService(DataSource dataSource) throws SQLException {
		this.connection = dataSource.getConnection(); 
	}
	
	public Person createPerson(Person person) {
		try {	
			String query = String.format("insert into person (name, surname, patronymic, age) "
					+ "values ('%s', '%s', '%s', %d);", 
					person.getName(), person.getSurname(), person.getPatronymic(), person.getAge());
			Statement statement = connection.createStatement();

			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				
	            if (generatedKeys.next()) {
	            	person.setId((int) generatedKeys.getLong(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
			System.out.println("Created person with id " + person.getId());
			
			return person;
		}
		catch (SQLException ex) {
			System.out.println(ex);
			//log.error("Error during inserting data to database!", ex);
			return null;
		}
		
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
