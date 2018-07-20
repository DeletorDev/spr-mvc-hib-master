package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Routes;

public interface RoutesDAO {
	
	public void addRoutes(Routes routes);
	public void updateRoutes(Routes routes);
	public Routes getRoutes(int id);
	public void deleteRoutes(int id);
	public List<Routes> getRoutes();

}
