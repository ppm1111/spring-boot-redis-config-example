package open.ppm1111.tdd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import open.ppm1111.tdd.model.Employee;
import open.ppm1111.tdd.repository.EmployeeRepository;

@Service
@CacheConfig(cacheNames = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    @Cacheable(value = "getAllEmployees", keyGenerator = "wiselyKeyGenerator")
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return employeeRepo.findAll();
    }

    @Override
    @Cacheable(value="redis", key ="#p0")
    public Employee findById(Long pId) {
        // TODO Auto-generated method stub
        Optional<Employee> _User = employeeRepo.findById(pId);
        System.out.println("從資料庫查找完.....");
        return Optional.ofNullable(_User).get().orElse(null);
    }

    @Override
    @CacheEvict(value = "getAllEmployees",allEntries=true)
    public void clearAllEmployees() {
        // TODO Auto-generated method stub
        
    }

    @Override
    @CacheEvict(value="employee", key ="#p0")
    public void clear(Integer pId) {
        // TODO Auto-generated method stub
        
    }
    
}
