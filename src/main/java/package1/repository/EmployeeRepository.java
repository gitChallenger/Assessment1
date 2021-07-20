package package1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import package1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

	Employee findByName(String name);

}
