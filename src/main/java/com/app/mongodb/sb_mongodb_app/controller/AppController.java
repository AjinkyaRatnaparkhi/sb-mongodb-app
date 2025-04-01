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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mongodb.sb_mongodb_app.model.Student;
import com.app.mongodb.sb_mongodb_app.repository.StudentRepository;
import com.app.mongodb.sb_mongodb_app.service.AppService;

@RestController
@Slf4j
@RequestMapping("/api")
public class AppController {


	@Autowired
	AppService appService;
	
	
	@GetMapping(value = "/getAllStudents")
	public List<Student> getAllStudents(Authentication authentication){

        log.info(" logged in user {}", authentication.getName());
		List<Student> list = appService.getAllStudents();
		return list;
	}
	
	
	@GetMapping("/findStudent")
	public List<Student> findStudent(@RequestParam String field,@RequestParam String value ) {
		

		List<Student> students = appService.findStudent(field, value);

		return students;
	}
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		Student savedStudent = appService.createStudent(student);
		return savedStudent;
	}
	
	@GetMapping("/app/status")
	public String getAppStatus() {
		return " app is running successfully ";
	}
	
	@GetMapping("/findByNameOrEmail")
	public List<Student> findByNameOrEmail(@RequestParam String name, @RequestParam String email) {
		List<Student> students = appService.findByNameOrEmail(name, email);
		return students;
	}
	
	@GetMapping("/findBySubjectsName")
	public List<Student> findBySubjectsName(@RequestParam String subjectName) {
		List<Student> students = appService.findBySubjectsName(subjectName);
		return students;
	}
}
