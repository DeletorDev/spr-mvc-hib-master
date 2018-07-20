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
@Table(name="routes")
public class Routes {
	
	
	public static final String ACTIVE_ROUTE = "A";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_route")
	 	
	private Integer id_route;
	
	private String desc_route;
		
	private double price;
	
	private String status = ACTIVE_ROUTE;
	
	public Integer getId() {
		return id_route;
	}
	public void setId(Integer id) {
		this.id_route = id;
	}
	
	/**
	 * @return the id_route
	 */
	public Integer getId_routes() {
		return id_route;
	}
	/**
	 * @param id_route the id_route to set
	 */
	public void setId_routes(Integer id_route) {
		this.id_route = id_route;
	}
	/**
	 * @return the desc_route
	 */
	public String getDesc_route() {
		return desc_route;
	}
	/**
	 * @param desc_route the desc_route to set
	 */
	public void setDesc_route(String desc_route) {
		this.desc_route = desc_route;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
