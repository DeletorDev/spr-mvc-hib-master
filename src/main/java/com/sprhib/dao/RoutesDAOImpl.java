package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Routes;

@Repository
public class RoutesDAOImpl implements RoutesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addRoutes(Routes routes) {
		getCurrentSession().save(routes);
	}

	public void updateRoutes(Routes routes) {
		Routes routesToUpdate = getRoutes(routes.getId());
		routesToUpdate.setDesc_route(routes.getDesc_route());
		routesToUpdate.setPrice(routes.getPrice());
		routesToUpdate.setStatus(routes.getStatus());
		getCurrentSession().update(routesToUpdate);
		
	}

	public Routes getRoutes(int id_routes) {
		Routes routes = (Routes) getCurrentSession().get(Routes.class, id_routes);
		return routes;
	}

	public void deleteRoutes(int id_routes) {
		Routes routes = getRoutes(id_routes);
		if (routes != null)
			getCurrentSession().delete(routes);
	}

	@SuppressWarnings("unchecked")
	public List<Routes> getRoutes() {
		return getCurrentSession().createQuery("from Routes order by 1").list() ;
	}

}
