package com.devcran.workshopmongo.dtos;

import java.io.Serializable;

import com.devcran.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
