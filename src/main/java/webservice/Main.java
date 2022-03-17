package webservice;

import javax.xml.ws.Endpoint;

import webservice.services.soap.PersonReadService;

public class Main {

	public static void main(String[] args) {
		String url = "http://127.0.0.1:8080/PersonService";
		
		System.out.println("Server started!");
		
		Endpoint.publish(url, new PersonReadService());
	}

}
