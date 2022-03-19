package webservice.exceptions;

import javax.xml.ws.WebFault;

import webservice.exceptions.faults.IncorrectArgumentFault;

@WebFault(faultBean = "webservice.exceptions.faults.IncorrectArgumentFault")
public class IncorrectArgumentException extends Exception {

	private static final long serialVersionUID = -5678882112887569304L;
	private final IncorrectArgumentFault fault;

	public IncorrectArgumentException(IncorrectArgumentFault fault) {
		super("Incorrect argument!");
		this.fault = fault;
	}
	
	public IncorrectArgumentException(String message, IncorrectArgumentFault fault) {
		super(message);
		this.fault = fault;
	}
	
	public IncorrectArgumentException(String message, IncorrectArgumentFault fault, Throwable cause) {
		super(message, cause);
		this.fault = fault;
	}
		
	public IncorrectArgumentFault getFaultInfo() {
		 return fault;
	}
}
