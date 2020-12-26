package open.ppm1111.tdd;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private int age;
    private Double salary;
}
