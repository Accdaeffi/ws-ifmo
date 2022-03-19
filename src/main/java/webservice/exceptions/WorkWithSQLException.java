package webservice.exceptions;

import javax.xml.ws.WebFault;

import webservice.exceptions.faults.WorkWithSQLFault;

@WebFault(faultBean = "webservice.exceptions.faults.WorkWithSQLFault")
public class WorkWithSQLException extends Exception {

	private static final long serialVersionUID = -1176041923687008928L;
	private final WorkWithSQLFault fault;

	public WorkWithSQLException(WorkWithSQLFault fault) {
		super("Error during work with SQL!");
		this.fault = fault;
	}
	
	public WorkWithSQLException(String message, WorkWithSQLFault fault) {
		super(message);
		this.fault = fault;
	}
	
	public WorkWithSQLException(String message, WorkWithSQLFault fault, Throwable cause) {
		super(message, cause);
		this.fault = fault;
	}
		
	public WorkWithSQLFault getFaultInfo() {
		 return fault;
	}

}
