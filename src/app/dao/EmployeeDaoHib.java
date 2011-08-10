package app.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import app.domain.Employee;

@Repository("employeeDao")
public class EmployeeDaoHib extends GenericDaoHib<Employee, Serializable> implements EmployeeDao {

}
