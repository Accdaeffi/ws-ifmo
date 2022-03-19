package webservice.exceptions.faults;

public class WorkWithSQLFault {

	private final static String BASE_MESSAGE = "Error during work with SQL!";
	
	private String message;

	public WorkWithSQLFault() {
		this.message = BASE_MESSAGE;
	}
	
	public String getMessage() {
		return message;
	}

}
