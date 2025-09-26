package com.example.demo_employee_mongo_db.repository;

import com.example.demo_employee_mongo_db.entity.EmployeeDb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeDbRepository extends MongoRepository<EmployeeDb, Long> {
    Optional<EmployeeDb> findById(Long employeeId);
}
