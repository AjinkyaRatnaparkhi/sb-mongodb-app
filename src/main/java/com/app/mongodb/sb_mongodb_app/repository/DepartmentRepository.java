package com.app.mongodb.sb_mongodb_app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.mongodb.sb_mongodb_app.model.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
	// You can add custom query methods here if needed
	// For example, find by name or location
	// List<Department> findByName(String name);
	// List<Department> findByLocation(String location);
	
	// Or you can use QuerydslPredicateExecutor for more complex queries
	// extends QuerydslPredicateExecutor<Department>

}
