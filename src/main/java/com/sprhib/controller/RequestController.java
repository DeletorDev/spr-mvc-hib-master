package com.sprhib.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Employee;
import com.sprhib.model.Request;
import com.sprhib.model.Routes;
import com.sprhib.service.EmployeeService;
import com.sprhib.service.RequestService;
import com.sprhib.service.RoutesService;

@Controller
@RequestMapping(value="/request")
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoutesService routesService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Employee.class, new PropertiesEditor(){
			@Override
		    public void setAsText(String text) {
		    	Employee employee = employeeService.getEmployee(Integer.valueOf(text));
		        setValue(employee);
		    }
		});
		dataBinder.registerCustomEditor(Routes.class, new PropertiesEditor(){
			@Override
		    public void setAsText(String text) {
				Routes routes = routesService.getRoutes(Integer.valueOf(text));
				setValue(routes);
		    }
		});
	}
	
	//@ModelAttribute("employees")
	public Collection<Employee> getEmployees() {
		return this.employeeService.getEmployees();
	}
	
	//@ModelAttribute("routes")
	public Collection<Routes> getRoutes() {
		return this.routesService.getRoutes();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addRequestPage() {
		ModelAndView modelAndView = new ModelAndView("add-request-form");
		modelAndView.addObject("request", new Request());
		Map<Integer, String> employeesMap = new HashMap<>();
		Map<Integer, String> routesMap = new HashMap<>();
		
		Collection<Employee> employees = this.employeeService.getEmployees();
		for (Employee employee : employees) {
			employeesMap.put(employee.getId(), employee.getLast_name()+", "+employee.getFirst_name());
		}			
		modelAndView.addObject("employees", employeesMap);
		
		
		Collection<Routes> routes = this.routesService.getRoutes();
		for (Routes route : routes) {
			routesMap.put(route.getId(), route.getDesc_route() );			
		}
		modelAndView.addObject("routes", routesMap);
		
		Request request = new Request();
	//	request.setRequestedDate(new Date());
		modelAndView.addObject("request", request);
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingRequest(@ModelAttribute("request") @Validated Request request, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Errors were found." + result.getAllErrors().size());
			//return modelAndView;
		}
		
		request.setRequestedDate(new Date());
		
		ModelAndView modelAndView = new ModelAndView("home");
		requestService.addRequest(request);
		
		String message = "Request was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfRequests() {
		ModelAndView modelAndView = new ModelAndView("list-of-requests");
		
		List<Request> requests = requestService.getRequests();
		modelAndView.addObject("requests", requests);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRequestPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-request-form");
		modelAndView.addObject("request", new Request());
		Map<Integer, String> employeesMap = new HashMap<>();
		Map<Integer, String> routesMap = new HashMap<>();
		
		Collection<Employee> employees = this.employeeService.getEmployees();
		for (Employee employee : employees) {
			employeesMap.put(employee.getId(), employee.getLast_name()+", "+employee.getFirst_name());
		}			
		modelAndView.addObject("employees", employeesMap);
		
		
		Collection<Routes> routes = this.routesService.getRoutes();
		for (Routes route : routes) {
			routesMap.put(route.getId(), route.getDesc_route() );			
		}		
		Request request = requestService.getRequest(id);
		
		modelAndView.addObject("request",request);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingRequest(@ModelAttribute Request request, @PathVariable Integer id) {
		String status = request.getStatus(); 
		if ( status == "D" ){
			request.setDeliveredDate(new Date());
		}
		
		ModelAndView modelAndView = new ModelAndView("home");		
		requestService.updateRequest(request);
		
		String message = "Request was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRequest(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		requestService.deleteRequest(id);
		String message = "Request was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
