package com.ebi.controller.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ebi.dao.model.Person;

@Component
public class PersonResponse {

	private List<Person> person;

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	
	
}
