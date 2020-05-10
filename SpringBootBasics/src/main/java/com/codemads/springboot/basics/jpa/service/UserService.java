/**
 * 
 */
package com.codemads.springboot.basics.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.codemads.springboot.basics.jpa.entity.User;

/**
 * 
 * UserService is a service later of DAO layer class to interact with DB
 * @author girishgowda
 *
 */
@Component
public class UserService {

	@Autowired
	private UserRepository repository;

	public void persistInfo(User user) {
		repository.save(user);
	}

}
