package service.providers.rest;

import service.rest.RestService;

public class SimpleRestService implements RestService {

	public void path() {
		System.out.println("Executing a simplerestservice resource...");
	}
	
}
