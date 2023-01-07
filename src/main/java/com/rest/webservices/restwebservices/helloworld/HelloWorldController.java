package com.rest.webservices.restwebservices.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello world";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public String pathParams(@PathVariable String name) {
		return "Hello, welcome to spring boot   " + name;
	}

}
