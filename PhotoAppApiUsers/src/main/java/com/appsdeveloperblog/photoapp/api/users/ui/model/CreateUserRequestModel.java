package com.appsdeveloperblog.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message="First name is required")
	@Size(min=2, message="First Name must not be less then two character")
	private String firstName;
	@NotNull(message="First name is required")
	@Size(min=2, message="First Name must not be less then two character")
	private String lastName;
	@NotNull(message="Email cannot be null")
	@Email
	private String email;
	@NotNull(message="Passowrd cannot be null")
	@Size(min=8, max=16, message="Password must be equal and grater then 8 characters and less then 16 characters")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
