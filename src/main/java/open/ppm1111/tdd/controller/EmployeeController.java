package open.ppm1111.tdd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import open.ppm1111.tdd.model.Employee;
import open.ppm1111.tdd.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping
    public List<Employee> get() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }
    
    @GetMapping("/find")
    public Employee getOne(@RequestParam(required = true) Long id) {
        Employee employees = employeeService.findById(id);
        return employees;
    }
    
    @PostMapping
    public String clear() {
        employeeService.clearAllEmployees();
        return "clear all";
    }
}
