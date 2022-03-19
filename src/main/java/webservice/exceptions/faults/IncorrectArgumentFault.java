package webservice.exceptions.faults;

public class IncorrectArgumentFault {

	private final static String BASE_MESSAGE = "Argument %s is incorrect!";
	
	private String message;

	public IncorrectArgumentFault(String argument) {
		this.message = String.format(BASE_MESSAGE, argument);
	}
	
	public String getMessage() {
		return message;
	}
}
