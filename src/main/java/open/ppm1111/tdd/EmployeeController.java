package open.ppm1111.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @PostMapping
    public String save(@RequestBody final Employee employee) {
        Gson gson = new GsonBuilder().create();

        employeeRepository.save(employee.getId(), gson.toJson(employee));
        return "Successfully added. Employee with id= " + employee.getId();
    }
    
    @GetMapping
    public String get(@RequestParam String id) {
        Gson gson = new Gson();

        String employeeString = employeeRepository.findById(id);
        Employee employee = gson.fromJson(employeeString, Employee.class);
        
        return "Successfully getted. Employee:  " + employee.toString();
    }
}
