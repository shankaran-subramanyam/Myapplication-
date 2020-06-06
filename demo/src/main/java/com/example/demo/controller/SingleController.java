package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.dto.Employer;
import com.example.demo.service.SingleServiceImpl;

@RestController
@RequestMapping(value = "/controller")
public class SingleController {

	@Autowired
	SingleServiceImpl singleServiceImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(SingleController.class);
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check() {
		LOGGER.info("Api is up and working fine");
		return "Api is working fine";
	}



	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@Valid @RequestBody Employee employee) {
		LOGGER.info("save method started in controller");
		singleServiceImpl.saveEmployee(employee);
		LOGGER.info("save method ended in controller");
		return "Saved Employee info";
	}



	@RequestMapping(value = "/employers", method = RequestMethod.POST)
	public String createEmployer(@Valid @RequestBody Employer employer) {
		LOGGER.info("createEmployee method started in controller");
		singleServiceImpl.saveEmployer(employer);
		LOGGER.info("createEmployee method ended in controller");
		return "saved successfully";
	}

	@RequestMapping(value = "/get{EmpName}", method = RequestMethod.GET)
	public Employee getEmployeeByName(@PathVariable(name="EmpName") String name) {
		LOGGER.info("getEmployee started in controller");
		Employee employee;
		employee = singleServiceImpl.findByName(name);
		LOGGER.info("getEmployee ends in controller");
		return employee;
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Employer> getAllEmployer() {
		LOGGER.info("getAllEmployer started in controller layer");
		List<Employer> list = singleServiceImpl.getAllEmployer();
		LOGGER.info("getAllEmployer ends in controller layer");
		return list;
	}
}
