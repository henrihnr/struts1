package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.PersonDao;
import app.domain.Person;

@Service("personService")
@Transactional(readOnly=true)
public class PersonServiceImpl implements PersonService {

	@Autowired private PersonDao personDao;
	
	public List<Person> listAll() {
		return personDao.listAll();
	}
	public List<Person> listAll(int offset, int pageSize) {
		return personDao.listAll(offset, pageSize);
	}
	
	public Person findById(Long id) {
		return personDao.findById(id);
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public Person save(Person person) {
		return personDao.save(person);
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Long id) {
		personDao.delete(id);
	}

}
