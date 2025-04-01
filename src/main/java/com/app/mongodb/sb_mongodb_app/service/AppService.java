package com.app.mongodb.sb_mongodb_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.app.mongodb.sb_mongodb_app.model.Student;
import com.app.mongodb.sb_mongodb_app.repository.DepartmentRepository;
import com.app.mongodb.sb_mongodb_app.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppService {

	final StudentRepository studentRepository;
	
	final MongoTemplate mongoTemplate;
	
	final DepartmentRepository departmentRepository; // if you want to use this in future

    AppService(StudentRepository studentRepository, MongoTemplate mongoTemplate , DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.mongoTemplate = mongoTemplate;
        this.departmentRepository = departmentRepository; // if you want to use this in future
    }
	
	public List<Student> getAllStudents() {
		List<Student> list = studentRepository.findAll();
		return list;
	}
	
	public List<Student> findStudent(String field, String value) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where(field).is(value));
		List<Student> students = mongoTemplate.find(query, Student.class);
	
		log.info(" mongo template size " + students.size());
		// repository method 
		
		List<Student> list2 =studentRepository.findByName(value);
		

		log.info(" studentRepository size " + list2.size());
		
		return students;
		
	}
	
	public Student createStudent(Student student) {
		
		if(student.getDepartment() != null) {

			departmentRepository.save(student.getDepartment());
		}
		studentRepository.save(student);
		log.info(" student created " + student.getId());
		return student;
	}
	
	public List<Student> findByNameOrEmail(String name,String email) {
		List<Student> students = studentRepository.findByNameOrEmail(name, email);
		log.info(" found students by name or email " + students.size()); 
		return students;
	}
	
	public List<Student> findBySubjectsName(String subjectName) {
		List<Student> students = studentRepository.findBySubjectsName(subjectName);
		log.info(" found students by subject name " + students.size());
		return students;
	}
}
