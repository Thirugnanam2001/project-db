package com.example.demo_employee_mongo_db.service;

import com.example.demo_employee_mongo_db.entity.EmployeeDb;
import com.example.demo_employee_mongo_db.repository.EmployeeDbRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeDbService {
    private EmployeeDbRepository employeeDbRepository;


    public EmployeeDb saveEmployee(EmployeeDb employeeDb){
        return employeeDbRepository.save(employeeDb);
    }

    public List<EmployeeDb> getAllEmployees(){
        return employeeDbRepository.findAll();
    }

    public Optional<EmployeeDb> getEmployeeById(Long employeeId){
        return  employeeDbRepository.findById(employeeId);
    }
}
