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
@Table(name = "vw_request")
public class VwRequest {

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
	
	/**
	 * @return the requestedDate
	 */
	public Date getRequestedDate() {
		return requestedDate;
	}

	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	/**
	 * @return the deliveredDate
	 */
	public Date getDeliveredDate() {
		return deliveredDate;
	}

	/**
	 * @param deliveredDate the deliveredDate to set
	 */
	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	/**
	 * @return the route
	 */
	public Routes getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Routes route) {
		this.route = route;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the id_request
	 */
	public Integer getId_request() {
		return id_request;
	}

	/**
	 * @param id_request
	 *            the id_request to set
	 */
	public void setId_request(Integer id_request) {
		this.id_request = id_request;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


}
