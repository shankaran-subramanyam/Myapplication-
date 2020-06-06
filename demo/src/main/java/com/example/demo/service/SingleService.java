package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Employee;
import com.example.demo.dto.Employer;

public interface SingleService {

	public Employee findByName(String name);

	public List<Employer> getAllEmployer();

	public void saveEmployee(Employee employee);

	public Employer saveEmployer(Employer employer);

}
