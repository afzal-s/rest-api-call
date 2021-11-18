package com.bridgelabz.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.helloworld.dto.User;

@RestController
@RequestMapping("/home")
public class HelloRestController {

	/**
	 * @url : 1. http://localhost:8081/home 2. http://localhost:8081/home/ 3.
	 *      http://localhost:8081/home/hello
	 * 
	 * @return normal greeting message
	 */
	// @RequestMapping(value = {"", "/", "/home"})
	@GetMapping(value = { "", "/", "/hello" })
	public String sayHello() {
		return "Hello From BridgeLabz.";
	}

	// http://localhost:8081/home/query?name=Afzal
	// @RequestMapping(method = RequestMethod.GET, value = "/query")
	@GetMapping(value = "/query")
	public String sayHello(@RequestParam(value = "name") String name) {
		return "Hello " + name + " From BridgeLabz.";
	}

	// http://localhost:8081/home/param/Afzal
	// @RequestMapping(method = RequestMethod.GET, value = "/param/{name}")
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
		return "Hello " + name + " From BridgeLabz.";
	}

	/**
	 * @url : http://localhost:8081/home/post
	 * @header : key: Content-Type, value: application/json
	 * 
	 * @body { "firstName": "Afzal", "lastName": "Shaikh" }
	 * 
	 * @param user
	 * @return greeting
	 */
	// @RequestMapping(method = RequestMethod.POST, value = "/post")
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getFirstName() + " " + user.getLastName() + 
				" From BridgeLabz";
	}

	// http://localhost:8081/home/put/Afzal?lastName=Shaikh
	// @RequestMapping(method = RequestMethod.PUT, value = "/put/{firstName}")
	@PutMapping("/put/{firstName}")
	public String sayHello(@PathVariable String firstName, @RequestParam("lastName") String lastName) {
		return "Hello " + firstName + " " + lastName + " From BridgeLabz.";
	}
}
