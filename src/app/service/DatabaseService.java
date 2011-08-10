package app.service;

import java.util.List;

import app.domain.Employee;

public interface DatabaseService {
	
	public List<Employee> listAll();
	public List<Employee> listAll(int offset, int pageSize);
	
	public Employee findById(Long id);
	public Employee save(Employee person);
	public void delete(Long id);

}
