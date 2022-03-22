package webservice.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtils {
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/ifmo-ws";
	private static final String JDBC_USER = "ifmo-ws";
	private static final String JDBC_PASSWORD = "ifmo-ws";

    @Resource(lookup = "jdbc/ifmo-ws")
	private DataSource dataSource;
    
    static ConnectionUtils instance = null;
        
    private ConnectionUtils() {
    	try {
    		InitialContext context = new InitialContext();
    		dataSource = (DataSource) context.lookup("jdbc/ifmo-ws");
                
     		Logger.getLogger(ConnectionUtils.class.getName()).log(Level.INFO, dataSource.toString());
     	} catch (NamingException ex) {
    	 	Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
     	}
            
     }
        
     public static ConnectionUtils getConnectionUtils() {
     	if (instance == null) {
        	instance = new ConnectionUtils();
     	}
     	return instance;
     }
	
	/*public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException ex) {
			System.out.println("Exception!");
			System.out.println(ex);
			// log.error("No database connection!");
		}
		return connection;
	 }*/
	
	public Connection getConnection() {
                System.out.println(dataSource == null);
            
		Connection result = null;
		
		try {
			result = dataSource.getConnection();
		} catch (SQLException ex) {
			System.out.println("Exception!");
			System.out.println(ex);
		}
		return result;
	}

}
