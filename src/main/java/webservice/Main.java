package webservice;

import javax.xml.ws.Endpoint;

import webservice.services.soap.*;

public class Main {

	public static void main(String[] args) {
		System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", 
				"false");

		String readServiceUrl = "http://127.0.0.1:8080/PersonReadService";
		Endpoint.publish(readServiceUrl, new PersonReadService());
		
		String deleteServiceUrl = "http://127.0.0.1:8080/PersonDeleteService";
		Endpoint.publish(deleteServiceUrl, new PersonDeleteService());
		
		String createServiceUrl = "http://127.0.0.1:8080/PersonCreateService";
		Endpoint.publish(createServiceUrl, new PersonCreateService());
		
		String updateServiceUrl = "http://127.0.0.1:8080/PersonUpdateService";
		Endpoint.publish(updateServiceUrl, new PersonUpdateService());
		
		System.out.println("Server started!");
	}

}
