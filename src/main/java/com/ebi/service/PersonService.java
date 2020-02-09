package com.ebi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.dao.PersonDao;
import com.ebi.dao.model.Person;

/**
 * Person Service Class
 * 
 * @author rahil
 */
@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public List<Person> getAllPerson() {
		return personDao.getAllPersons();
	}

	public void savePerson(Person person) {
		personDao.savePerson(person);
	}

	public void deletePerson(int personId) {
		personDao.deletePersonById(personId);
	}
}
