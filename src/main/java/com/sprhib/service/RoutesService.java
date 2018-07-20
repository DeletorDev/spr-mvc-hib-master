package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Routes;

public interface RoutesService {
	
	public void addRoutes(Routes routes);
	public void updateRoutes(Routes routes);
	public Routes getRoutes(int id);
	public void deleteRoutes(int id);
	public List<Routes> getRoutes();

}
