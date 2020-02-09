package com.ebi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebi.dao.model.Person;

/**
 * Person data access class
 * 
 * @author rahil
 */
@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * @return List of Persons
	 */
	public List<Person> getAllPersons() {
		List<Person> listPersons = new ArrayList<Person>();
		personRepository.findAll().forEach(listPersons::add);
		return listPersons;
	}

	/**
	 * @return Delete Person By id
	 */
	public void deletePersonById(int personId) {
		personRepository.deleteById(personId);
	}

	/**
	 * Save / update a Person
	 * 
	 * @param person
	 */
	public void savePerson(Person person) {
		if (null != person) {
			personRepository.save(person);
		}
	}
}
