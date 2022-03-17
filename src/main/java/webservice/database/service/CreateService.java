package webservice.database.service;

import java.sql.Connection;
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
	
	public boolean createPerson(Person person) {
		try {	
			String query = String.format("insert into person (name, surname, patronymic, age) "
					+ "values ('%s', '%s', '%s', %d);", 
					person.getName(), person.getSurname(), person.getPatronymic(), person.getAge());
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			
			return true;
		}
		catch (SQLException ex) {
			//log.error("Error during inserting data to database!", ex);
			return false;
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
