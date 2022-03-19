package webservice.exceptions.faults;

public class PersonWithSuchIdNotFoundFault {

	private final static String BASE_MESSAGE = "Can't found person with id %d!";
	
	private String message;

	public PersonWithSuchIdNotFoundFault(int id) {
		this.message = String.format(BASE_MESSAGE, id);
	}
	
	public String getMessage() {
		return message;
	}

}
