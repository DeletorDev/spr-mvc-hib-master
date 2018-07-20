package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Routes;
import com.sprhib.service.RoutesService;

@Controller
@RequestMapping(value="/routes")
public class RoutesController {
	
	@Autowired
	private RoutesService routesService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addRoutesPage() {
		ModelAndView modelAndView = new ModelAndView("add-route-form");
		modelAndView.addObject("routes", new Routes());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingRoutes(@ModelAttribute Routes routes) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		routesService.addRoutes(routes);
		
		String message = "Routes was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfRoutes() {
		ModelAndView modelAndView = new ModelAndView("list-of-routes");
		
		List<Routes> routes = routesService.getRoutes();
		modelAndView.addObject("routes", routes);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRoutesPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-routes-form");
		Routes routes = routesService.getRoutes(id);
		modelAndView.addObject("routes",routes);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingRoutes(@ModelAttribute Routes routes, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		routesService.updateRoutes(routes);
		
		String message = "Routes was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRoutes(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		routesService.deleteRoutes(id);
		String message = "Routes was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
