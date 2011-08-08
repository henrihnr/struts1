package app.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.actions.LookupDispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import app.service.PersonService;

public class AppLookupDispatchAction extends LookupDispatchAction {

	protected final Log logger = LogFactory.getLog(getClass());
		
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("app.nav.search", "search");
		map.put("app.nav.show", "show");
		map.put("app.nav.add", "add");
		map.put("app.nav.modify", "modify");
		map.put("app.nav.delete", "delete");
		
		return map;
	}

	public void setServlet(ActionServlet actionServlet) {
		super.setServlet(actionServlet);
		
		ServletContext servletContext = actionServlet.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		
		this.personService = (PersonService) wac.getBean("personService");
	}
	
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

}
