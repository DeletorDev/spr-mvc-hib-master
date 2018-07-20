package com.sprhib.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "request")
public class Request {
	
	public static final String STATUS_REQUEST = "R";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_request")

	private Integer id_request;
	
	@ManyToOne
	@JoinColumn(name = "id_employee")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "id_route")
	private Routes route;
	
	private Integer quantity;
	
	@Column(name = "dt_requested", nullable = false)
	private Date requestedDate;

	@Column(name = "dt_delivered")
	private Date deliveredDate;
	
	@Column(name = "status", nullable = false)
	private String status = STATUS_REQUEST ;
	
	/**
	 * @return the id_request
	 */
	public Integer getId() {
		return id_request;
	}

	/**
	 * @param id_request
	 *            the id_request to set
	 */
	public void setId(Integer id) {
		this.id_request = id;
	}
	
	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	
	public Routes getRoute() {
		return route;
	}

	public void setRoute(Routes route) {
		this.route = route;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
