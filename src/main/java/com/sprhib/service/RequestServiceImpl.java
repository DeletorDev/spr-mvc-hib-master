package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.RequestDAO;
import com.sprhib.model.Request;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestDAO requestDAO;

	public void addRequest(Request request) {
		requestDAO.addRequest(request);		
	}

	public void updateRequest(Request request) {
		requestDAO.updateRequest(request);
	}

	public Request getRequest(int id) {
		return requestDAO.getRequest(id);
	}

	public void deleteRequest(int id) {
		requestDAO.deleteRequest(id);
	}

	public List<Request> getRequests() {
		return requestDAO.getRequests();
	}

}
