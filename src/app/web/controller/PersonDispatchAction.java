package app.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import app.domain.Person;
import app.web.form.PersonForm;

public class PersonDispatchAction extends AppLookupDispatchAction {

	public ActionForward search (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		PersonForm personForm = (PersonForm) form;
		
		List<Person> persons = getPersonService().listAll(personForm.getOffset(), personForm.getPageSize());
		
		if (persons != null && !persons.isEmpty()) {
			request.setAttribute("persons", persons);
		}
		
		return mapping.findForward("search");
	}
	
	public ActionForward show (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		PersonForm personForm = (PersonForm) form;
		
		try {
			Long id = personForm.getId();
			if (id != null) {
				Person person = getPersonService().findById(id);
				
				BeanUtils.copyProperties(personForm, person);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return mapping.findForward("detail");
	}
	
	public ActionForward add (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		PersonForm personForm = (PersonForm) form;
		
		try {
			Person person = new Person();
			
			BeanUtils.copyProperties(person, personForm);
			person.setId(null);
			
			person = getPersonService().save(person);
			BeanUtils.copyProperties(personForm, person);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return mapping.findForward("detail");
	}
	
	public ActionForward modify (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		PersonForm personForm = (PersonForm) form;
		
		try {
			Person person = getPersonService().findById(personForm.getId());
				
			BeanUtils.copyProperties(person, personForm);
			
			getPersonService().save(person);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return mapping.findForward("detail");
	}
	
	public ActionForward delete (ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		PersonForm personForm = (PersonForm) form;
		
		try {
			getPersonService().delete(personForm.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return search(mapping, form, request, response);
	}
	
}
