package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Request;

public interface RequestService {
	
	public void addRequest(Request request);
	public void updateRequest(Request request);
	public Request getRequest(int id);
	public void deleteRequest(int id);
	public List<Request> getRequests();

}
