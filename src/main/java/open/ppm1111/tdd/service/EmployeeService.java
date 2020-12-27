package open.ppm1111.tdd.service;

import java.util.List;

import open.ppm1111.tdd.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee findById(Long pId);
    
    void clearAllEmployees();
    
    void clear(Integer pId);
}
