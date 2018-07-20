package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.RoutesDAO;
import com.sprhib.model.Routes;

@Service
@Transactional
public class RoutesServiceImpl implements RoutesService {
	
	@Autowired
	private RoutesDAO routesDAO;

	public void addRoutes(Routes routes) {
		routesDAO.addRoutes(routes);		
	}

	public void updateRoutes(Routes routes) {
		routesDAO.updateRoutes(routes);
	}

	public Routes getRoutes(int id) {
		return routesDAO.getRoutes(id);
	}

	public void deleteRoutes(int id) {
		routesDAO.deleteRoutes(id);
	}

	public List<Routes> getRoutes() {
		return routesDAO.getRoutes();
	}

}
