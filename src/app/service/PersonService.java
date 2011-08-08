package app.service;

import java.util.List;

import app.domain.Person;

public interface PersonService {
	
	public List<Person> listAll();
	public List<Person> listAll(int offset, int pageSize);
	
	public Person findById(Long id);
	public Person save(Person person);
	public void delete(Long id);

}
