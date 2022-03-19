package webservice.exceptions;

import javax.xml.ws.WebFault;

import webservice.exceptions.faults.PersonWithSuchIdNotFoundFault;

@WebFault(faultBean = "webservice.exceptions.faults.PersonWithSuchIdNotFoundFault")
public class PersonWithSuchIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1585787107936011181L;
	private final PersonWithSuchIdNotFoundFault fault;

	public PersonWithSuchIdNotFoundException(PersonWithSuchIdNotFoundFault fault) {
		super("No such person!");
		this.fault = fault;
	}
	
	public PersonWithSuchIdNotFoundException(String message, PersonWithSuchIdNotFoundFault fault) {
		super(message);
		this.fault = fault;
	}
	
	public PersonWithSuchIdNotFoundException(String message, PersonWithSuchIdNotFoundFault fault, Throwable cause) {
		super(message, cause);
		this.fault = fault;
	}
		
	public PersonWithSuchIdNotFoundFault getFaultInfo() {
		 return fault;
	}

}
