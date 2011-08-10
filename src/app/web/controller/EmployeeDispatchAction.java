package app.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import app.domain.Employee;
import app.web.form.EmployeeForm;

public class EmployeeDispatchAction extends AppLookupDispatchAction {

	public ActionForward search (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		EmployeeForm employeeForm = (EmployeeForm) form;
		
		List<Employee> persons = getDatabaseService().listAll(employeeForm.getOffset(), employeeForm.getPageSize());
		
		if (persons != null && !persons.isEmpty()) {
			request.setAttribute("employees", persons);
		}
		
		return mapping.findForward("search");
	}
	
	public ActionForward show (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		EmployeeForm employeeForm = (EmployeeForm) form;
		
		try {
			Long id = employeeForm.getId();
			if (id != null) {
				Employee employee = getDatabaseService().findById(id);
				
				BeanUtils.copyProperties(employeeForm, employee);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return mapping.findForward("detail");
	}
	
	public ActionForward add (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		EmployeeForm employeeForm = (EmployeeForm) form;
		
		try {
			Employee employee = new Employee();
			
			BeanUtils.copyProperties(employee, employeeForm);
			employee.setId(null);
			
			employee = getDatabaseService().save(employee);
			BeanUtils.copyProperties(employeeForm, employee);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return mapping.findForward("detail");
	}
	
	public ActionForward modify (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		EmployeeForm employeeForm = (EmployeeForm) form;
		
		try {
			Employee employee = getDatabaseService().findById(employeeForm.getId());
				
			BeanUtils.copyProperties(employee, employeeForm);
			
			getDatabaseService().save(employee);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return mapping.findForward("detail");
	}
	
	public ActionForward delete (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		EmployeeForm employeeForm = (EmployeeForm) form;
		
		try {
			getDatabaseService().delete(employeeForm.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return search(mapping, form, request, response);
	}
	
}
