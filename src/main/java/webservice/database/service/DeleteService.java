package webservice.database.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import webservice.database.ConnectionUtils;

public class DeleteService {

	private final Connection connection;

	public DeleteService() {
		connection = ConnectionUtils.getConnection();
	}
	
	public DeleteService(DataSource dataSource) throws SQLException {
		this.connection = dataSource.getConnection(); 
	}
	
	public boolean deletePerson(int id) {
		try {	
			String query = String.format("delete from person where person.id = %d ;", 
					id);
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			
			return true;
		}
		catch (SQLException ex) {
			System.out.println(ex);
			//log.error("Error during deleting data from database!", ex);
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
