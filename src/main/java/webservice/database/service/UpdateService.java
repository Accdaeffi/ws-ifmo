package webservice.database.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import webservice.database.ConnectionUtils;
import webservice.database.model.Person;

public class UpdateService {

	private final Connection connection;

	public UpdateService() {
		connection = ConnectionUtils.getConnection();
	}
	
	public UpdateService(DataSource dataSource) throws SQLException {
		this.connection = dataSource.getConnection(); 
	}
	
	public boolean updatePerson(Person person) 
			throws SQLException {
		String query = String.format("update person set name='%s', surname='%s', patronymic='%s', age=%d "
				+ "where id = %d", 
				person.getName(), person.getSurname(), person.getPatronymic(), person.getAge(), person.getId());
		
		if (query.contains(";")) {
			throw new SQLException("SQL Injection detected!");
		}
		
		Statement statement = connection.createStatement();

		statement.executeUpdate(query);
			
		return true;	
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
