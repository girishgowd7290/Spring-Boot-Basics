/**
 * 
 */
package com.codemads.springboot.basics;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * User Bean class with validation of fields
 * @author girishgowda
 *
 */
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name should be of atleast 2 chars")
	private String name;

	@Past
	private Date birthDate;

	
	public User() {
		super();
	}

	public User(int id, String name, Date birthdate) {
		this.id=id;
		this.name = name;
		this.birthDate=birthdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
