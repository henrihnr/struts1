package app.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

public class AppRequestProcessor extends RequestProcessor {

	public AppRequestProcessor () {
		super();
	}
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		super.process(request, response);
	}
}
