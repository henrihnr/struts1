package app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -9113678553568327829L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=10)
	private String npk;
	
	@Column(length=50)
	private String name;
	
	@Column(length=1)
	private Character gender;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String email;
    private String phone;
	
	public Employee() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNpk() {
		return npk;
	}
	public void setNpk(String npk) {
		this.npk = npk;
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
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
