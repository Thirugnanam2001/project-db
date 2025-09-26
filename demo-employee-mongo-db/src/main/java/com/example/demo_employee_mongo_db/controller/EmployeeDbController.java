package com.example.demo_employee_mongo_db.controller;

import com.example.demo_employee_mongo_db.entity.EmployeeDb;
import com.example.demo_employee_mongo_db.service.EmployeeDbService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeDbController {
    private EmployeeDbService employeeDbService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("employeeDb", new EmployeeDb());
        return "index";
    }

    @PostMapping("/employeeSave")
    public String saveEmployee(@ModelAttribute EmployeeDb employeeDb, Model model) {
        employeeDbService.saveEmployee(employeeDb);
        model.addAttribute("message", "Employee Saved Successfully!");
//        return "index";
        return "redirect:/displayAll";
    }
    @PostMapping("/employee/api")
    @ResponseBody
    public EmployeeDb saveEmployeeApi(@RequestBody EmployeeDb employeeDb) {
        return employeeDbService.saveEmployee(employeeDb);
    }

    @GetMapping("/displayAll")
    @ResponseBody
    public List<EmployeeDb> displayAllEmployeesDb() {
        return employeeDbService.getAllEmployees();
    }

    @GetMapping("/display/{employeeId}")
    @ResponseBody
    public EmployeeDb displayEmployeesDb(@PathVariable Long employeeId){
        return employeeDbService.getEmployeeById(employeeId).orElseThrow(() -> new RuntimeException("Employee Not found"));
    }
    //    @GetMapping("/displayAll")
//    public String displayAllEmployeesDb(Model model) {
//        List<EmployeeDb> employees = employeeDbService.getAllEmployees();
//        model.addAttribute("employees", employees);
//        return "displayAll"; // create displayAll.html
//    }

    //    @PostMapping(value = "/employeeSave", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public Object saveEmployee(EmployeeDb employeeDb,
//                               @RequestBody(required = false) EmployeeDb employeeDbJson) {
//        // If JSON request (Postman)
//        if (employeeDb != null) {
//            return employeeDbService.saveEmployee(employeeDb); // return JSON
//        }
//
//        // If form submission (index.html)
//        employeeDbService.saveEmployee(employeeDb);
//        return "redirect:/displayAll"; // redirect after form submit
//    }
}

