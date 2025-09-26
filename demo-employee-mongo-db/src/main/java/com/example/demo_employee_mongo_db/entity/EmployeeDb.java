package com.example.demo_employee_mongo_db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDb {
    @Id
    private Long employeeId;
    private String name;
    private String email;
    private String location;

}
