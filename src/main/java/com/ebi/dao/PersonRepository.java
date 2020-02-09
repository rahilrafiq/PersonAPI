package com.ebi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ebi.dao.model.Person;

/**
 * @author rahil
 *         Crud Repository for Person
 */
public interface PersonRepository extends CrudRepository<Person, Integer>
{

}
