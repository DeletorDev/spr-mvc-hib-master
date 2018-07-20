package com.sprhib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name="employee")
public class Employee {
	
	
	public static final String ACTIVE_EMPLOYEE = "A";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee")
		
	private Integer id_employee;
			
	private String nu_badge;
		
	private String first_name;
	
	private String last_name;
	
	private String status = ACTIVE_EMPLOYEE;
	
	public Integer getId() {
		return id_employee;
	}
	public void setId(Integer id) {
		this.id_employee = id;
	}
	public String getNu_badge() {
		return nu_badge;
	}
	public void setNu_badge(String nu_badge) {
		this.nu_badge = nu_badge;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
