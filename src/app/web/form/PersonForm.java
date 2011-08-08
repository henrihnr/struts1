package app.web.form;

import java.text.ParseException;
import java.util.Date;

import app.util.DateUtil;

public class PersonForm extends BaseForm {

	private static final long serialVersionUID = 1716019710225925474L;
	
	private Long id;
	private String name;
	private Character gender;
	private String webDob;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	
	public Date getDob() throws ParseException {
		return DateUtil.convertStringToDate(getWebDob());
	}
	public void setDob(Date dob) {
		setWebDob(DateUtil.convertDateToString(dob));
	}
	
	public String getWebDob() {
		return webDob;
	}
	public void setWebDob(String webDob) {
		this.webDob = webDob;
	}
	
}
