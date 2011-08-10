package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.EmployeeDao;
import app.domain.Employee;

@Service("databaseService")
@Transactional(readOnly=true)
public class DatabaseServiceImpl implements DatabaseService {

	@Autowired private EmployeeDao employeeDao;
	
	public List<Employee> listAll() {
		return employeeDao.listAll();
	}
	public List<Employee> listAll(int offset, int pageSize) {
		return employeeDao.listAll(offset, pageSize);
	}
	
	public Employee findById(Long id) {
		return employeeDao.findById(id);
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public Employee save(Employee person) {
		return employeeDao.save(person);
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Long id) {
		employeeDao.delete(id);
	}

}
