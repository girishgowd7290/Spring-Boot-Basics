package com.codemads.springboot.basics.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.codemads.springboot.basics.jpa.entity.User;

public class UserJpaRepoTest {
	
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		
		User user = new User("Girish", "Dev Engg");
		
		UserJpaRepoTest jpaRepoTest = new UserJpaRepoTest();
		jpaRepoTest.persistInfo(user);
	}
	
	public void persistInfo(User user) {
		repository.save(user);
	}
}
