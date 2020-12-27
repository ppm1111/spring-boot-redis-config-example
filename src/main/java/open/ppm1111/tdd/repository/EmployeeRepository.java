package open.ppm1111.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import open.ppm1111.tdd.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}