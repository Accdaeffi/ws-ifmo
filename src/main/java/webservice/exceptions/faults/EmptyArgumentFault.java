package webservice.exceptions.faults;

public class EmptyArgumentFault {

	private final static String BASE_MESSAGE = "Argument %s is empty!";
	
	private String message;

	public EmptyArgumentFault(String argument) {
		this.message = String.format(BASE_MESSAGE, argument);
	}
	
	public String getMessage() {
		return message;
	}

}
