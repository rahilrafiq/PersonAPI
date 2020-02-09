package com.ebi.controller;

import static com.ebi.constants.EBIConstants.PERSON;
import static com.ebi.constants.EBIConstants.PERSONS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.common.EBIRespponse;
import com.ebi.controller.dto.PersonDto;
import com.ebi.controller.dto.PersonResponse;
import com.ebi.dao.model.Hobby;
import com.ebi.dao.model.Person;
import com.ebi.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	/**
	 * Get list of all Persons
	 * 
	 * @return PersonResponse
	 */
	@RequestMapping(value = PERSONS, method = RequestMethod.GET)
	public ResponseEntity<PersonResponse> getPersons() {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setPerson(personService.getAllPerson());
		return ResponseEntity.ok().body(personResponse);
	}

	/**
	 * Update a person against personId
	 * 
	 * @param personDto
	 * @return
	 */
	@RequestMapping(value = PERSON, method = RequestMethod.PUT)
	public ResponseEntity<EBIRespponse> updatePerson(@RequestBody PersonDto personDto) {
		EBIRespponse ebiRespponse = new EBIRespponse();
		ModelMapper modelMapper = new ModelMapper();

		try {
			Person person = modelMapper.map(personDto, Person.class);
			person.setHobby(mapHobby(personDto.getHobby()));
			personService.savePerson(person);
			ebiRespponse.setResponseCode(1);
			ebiRespponse.setStatus("Success");
		} catch (RuntimeException e) {
			ebiRespponse.setResponseCode(0);
			ebiRespponse.setStatus("Failure: " + e.getMessage());
		}
		return ResponseEntity.ok().body(null);
	}

	/**
	 * Delete a person using PersonId
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = PERSON, method = RequestMethod.DELETE)
	public ResponseEntity<EBIRespponse> deletePerson(@RequestBody Person person) {
		EBIRespponse ebiRespponse = new EBIRespponse();
		try {
			personService.deletePerson(person.getId());
			ebiRespponse.setResponseCode(1);
			ebiRespponse.setStatus("Success");
		} catch (RuntimeException e) {
			ebiRespponse.setResponseCode(0);
			ebiRespponse.setStatus("Failure: " + e.getMessage());
		}
		return ResponseEntity.ok().body(null);
	}

	/**
	 * Gets the Person JSON and save new person
	 * 
	 * @return response
	 */
	@RequestMapping(value = PERSON, method = RequestMethod.POST)
	public ResponseEntity<EBIRespponse> createPerson(@RequestBody PersonDto personDto) {
		EBIRespponse ebiRespponse = new EBIRespponse();
		ModelMapper modelMapper = new ModelMapper();

		try {
			Person person = modelMapper.map(personDto, Person.class);
			person.setHobby(mapHobby(personDto.getHobby()));
			personService.savePerson(person);
			ebiRespponse.setResponseCode(1);
			ebiRespponse.setStatus("Success");
		} catch (RuntimeException e) {
			ebiRespponse.setResponseCode(0);
			ebiRespponse.setStatus("Failure: " + e.getMessage());
		}
		return ResponseEntity.ok().body(ebiRespponse);
	}

	private Set<Hobby> mapHobby(List<String> dtoHobbies) {
		Set<Hobby> hobbies = new HashSet<Hobby>();
		for (String hobby : dtoHobbies) {
			Hobby enHobby = new Hobby();
			enHobby.setHobby(hobby);
			hobbies.add(enHobby);
		}
		return hobbies;
	}

}
