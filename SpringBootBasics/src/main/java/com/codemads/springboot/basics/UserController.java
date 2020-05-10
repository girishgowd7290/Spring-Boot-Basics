/**
 * 
 */
package com.codemads.springboot.basics;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * UserController is a Rest Controller classs
 * 
 * This connects to Sevice layer or DAO layer to get data
 * @author girishgowda
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserDaoService service;
	
	
	@GetMapping("/users")
	protected List<User> retrieveAllUsers(){
		return service.findAll();
	}

	//Retrieve a particular user
	@GetMapping("/user/{id}")
	private Resource<User> retrieveUserById(@PathVariable int id){
		User user = service.findOne(id);

		// Throw custom exception 
		if(null == user) {
			throw new UserNotFoundException("Id " + id);
		}

		// Used to send additional data
		Resource<User> resource = new Resource<User>(user);

		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	// To Save a user 
	@PostMapping("/user")
	private User persistUser(@Valid @RequestBody User user){
		return service.save(user);
	}

	// To Delete a user
	@DeleteMapping("/user/{id}")
	private User deleteUserById(@PathVariable int id){
		User user = service.deleteById(id);

		if(null == user) {
			throw new UserNotFoundException("Delete user not found ::  " + id);
		}
		return user;
	}
	
}
