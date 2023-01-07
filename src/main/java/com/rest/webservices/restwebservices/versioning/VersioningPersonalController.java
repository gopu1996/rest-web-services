package com.rest.webservices.restwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonalController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new PersonV2.Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/header", headers =  "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonHeaders() {
		return new PersonV1("Bob Charlie");
	}
	

}
