package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.SingleController;
import com.example.demo.dao.SingleDao;
import com.example.demo.dto.Employee;
import com.example.demo.dto.Employer;

@Service
public class SingleServiceImpl implements SingleService {
	
	@Autowired
	SingleDao singleDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SingleServiceImpl.class);

	@Override
	public Employee findByName(String name) {
		LOGGER.info("findByName  method started in service started");
		Employee employee =singleDao.findByName(name);
		LOGGER.info(employee.toString());
		LOGGER.info("findByName  method ends in service started");
		return employee;
	}
	
	@Override
	public Employer saveEmployer(Employer employer) {
		LOGGER.info("saveEmployer method in service started");
		singleDao.saveEmployer(employer);
		LOGGER.info("saveEmployer method in service started");
		return null;
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		LOGGER.info("saveEmployee method in service started");
		if(employee!=null)
		{
		singleDao.saveEmployee(employee);
		}
		LOGGER.info("saveEmployee method in service ended");
	}

	@Override
	public List<Employer> getAllEmployer() {
		LOGGER.info("getAllEmployer started in service layer");
		List<Employer> list = singleDao.getAllEmployer();
		
		LOGGER.info("getAllEmployer ends in service layer");
		return list;
	}





}
