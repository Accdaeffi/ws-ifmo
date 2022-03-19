package webservice.exceptions;

import javax.xml.ws.WebFault;

import webservice.exceptions.faults.EmptyArgumentFault;

@WebFault(faultBean = "webservice.exceptions.faults.EmptyArgumentFault")
public class EmptyArgumentException extends Exception {

	private static final long serialVersionUID = -7382691528512756973L;
	private final EmptyArgumentFault fault;

	public EmptyArgumentException(EmptyArgumentFault fault) {
		super("Empty argument!");
		this.fault = fault;
	}
	
	public EmptyArgumentException(String message, EmptyArgumentFault fault) {
		super(message);
		this.fault = fault;
	}
	
	public EmptyArgumentException(String message, EmptyArgumentFault fault, Throwable cause) {
		super(message, cause);
		this.fault = fault;
	}
		
	public EmptyArgumentFault getFaultInfo() {
		 return fault;
	}

}
