package com.app.mongodb.sb_mongodb_app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;

import com.app.mongodb.sb_mongodb_app.model.Student;
import java.util.List;


@Component
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByName(String name);
	List<Student> findByNameOrEmail(String name, String email);
	List<Student> findBySubjectsName(String subjectName);
}
