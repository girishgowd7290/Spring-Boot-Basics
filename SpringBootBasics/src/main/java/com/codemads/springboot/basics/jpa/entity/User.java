package com.codemads.springboot.basics.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 
 * User bean is used as an Entity class to persist data in DB
 * @Entity - Used to map it to a table
 * 
 * @author girishgowda
 *
 * @Id - Makes the Pvt key of the table
 * @GeneratedValue - Generates a sequaentioal value
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String role;

	protected User() {

	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
	}
}
