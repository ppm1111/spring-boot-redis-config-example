package open.ppm1111.tdd;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    private final String EMPLOYEE_CACHE = "employee";
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    private HashOperations<String, String, String> hashOperations;
 
    // This annotation makes sure that the method needs to be executed after
    // dependency injection is done to perform any initialization.
    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = stringRedisTemplate.opsForHash();
    }
 
    public void save(String key, String value) {
        hashOperations.put(EMPLOYEE_CACHE, key, value);
    }

    public String findById(final String key) {
        return hashOperations.get(EMPLOYEE_CACHE, key);
    }
 
    public Map<String, String> findAll() {
        return hashOperations.entries(EMPLOYEE_CACHE);
    }
 
   
    public void delete(String key) {
        hashOperations.delete(EMPLOYEE_CACHE, key);
    }
}
