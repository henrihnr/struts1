package app.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import app.domain.Person;

@Repository("personDao")
public class PersonDaoHib extends GenericDaoHib<Person, Serializable> implements PersonDao {

}
