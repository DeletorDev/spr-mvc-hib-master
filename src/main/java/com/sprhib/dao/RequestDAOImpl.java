package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Request;

@Repository
public class RequestDAOImpl implements RequestDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addRequest(Request request) {
		getCurrentSession().save(request);
	}

	public void updateRequest(Request request) {
		Request requestToUpdate = getRequest(request.getId());
		requestToUpdate.setQuantity(request.getQuantity());
		requestToUpdate.setStatus(request.getStatus());
		requestToUpdate.setDeliveredDate(request.getDeliveredDate());
		requestToUpdate.setRequestedDate(request.getRequestedDate());
		requestToUpdate.setEmployee(request.getEmployee());
		requestToUpdate.setRoute(request.getRoute());
		getCurrentSession().update(requestToUpdate);
		
	}

	public Request getRequest(int id_request) {
		Request request = (Request) getCurrentSession().get(Request.class, id_request);
		return request;
	}

	public void deleteRequest(int id_request) {
		Request request = getRequest(id_request);
		if (request != null)
			getCurrentSession().delete(request);
	}

	@SuppressWarnings("unchecked")
	public List<Request> getRequests() {
		return getCurrentSession().createQuery("from Request where status='R'").list();
	}

}
