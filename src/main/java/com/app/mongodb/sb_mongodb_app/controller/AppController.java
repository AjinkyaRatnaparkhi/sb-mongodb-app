package com.app.mongodb.sb_mongodb_app.controller;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mongodb.sb_mongodb_app.model.Student;
import com.app.mongodb.sb_mongodb_app.repository.StudentRepository;

@RestController
@Slf4j
public class AppController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@GetMapping(value = "/getAllStudents")
	public List<Student> getAllStudents(Authentication authentication){

        log.info(" logged in user {}", authentication.getName());
		List<Student> list = studentRepository.findAll();
		return list;
	}
	
	
	@GetMapping("/findStudent")
	public List<Student> findStudent(@RequestParam String field,@RequestParam String value ) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where(field).is(value));
		List<Student> students = mongoTemplate.find(query, Student.class);
	
		log.info(" mongo template size " + students.size());
		// repository method 
		
		List<Student> list2 =studentRepository.findByName(value);
		

		log.info(" studentRepository size " + list2.size());
		
		return students;
	}
	
	@GetMapping("/app/status")
	public String getAppStatus() {
		return " app is running successfully ";
	}
}
