package com.example.demo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Employee;
import com.example.demo.dto.Employer;

@Repository
public class SingleDao {


	private MongoTemplate mongoTemplate;

	@Autowired
	public SingleDao(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(SingleDao.class);

	public Employee findByName(String name) {
		LOGGER.info("Input name is " + name);
		LOGGER.info("findByName method started in dao started");
		Query query = new Query();
		query.addCriteria(Criteria.where("lastName").is(name));
		List<Employee> list = mongoTemplate.find(query, Employee.class);

		LOGGER.info("list size is " + list.size());
		Employee employee = list.get(0);
		LOGGER.info("Employee info is " + employee.toString());
		LOGGER.info("findByName method ends in dao started");
		return employee;
	}

	public Employer saveEmployer(Employer employer) {
		LOGGER.info("save method in dao started");
		mongoTemplate.save(employer);
		LOGGER.info("save method in dao ended");
		return employer;
	}

	public Employee saveEmployee(Employee employee) {
		LOGGER.info("saveEmployee method in dao started");
		mongoTemplate.save(employee);
		LOGGER.info("saveEmployee method in dao ended");
		return employee;
	}

	public List<Employer> getAllEmployer() {
		LOGGER.info("getAllEmployer started in dao layer");
		List<Employer> list = mongoTemplate.findAll(Employer.class);

		LOGGER.info("Size of list is " + list.size());
		for (Employer employer : list) {
			LOGGER.info("Employer info is" + employer.toString());
		}

		return list;

	}

}
