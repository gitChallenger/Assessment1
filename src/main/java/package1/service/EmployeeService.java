package package1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import package1.entity.Employee;
import package1.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Get all employees
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	//Get an Employee details by Id (primary key)
	public Employee getEmployeeById(String email) {
		return employeeRepository.findById(email).orElse(null);
	}
	
	//Get an Employee details by name
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}
	
	//Create new Employee
	public Employee createNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//Delete an Employee
	public String deleteEmployee(String email) {
		employeeRepository.deleteById(email);
		return "Deleted";
	}
	
	//Update Employee Details
	public Employee updateEmployee(Employee employee) {
		Employee emp = employeeRepository.findById(employee.getEmail()).orElse(null);
		emp.setEmail(employee.getEmail());
		emp.setName(employee.getName());
		return employeeRepository.save(emp);
		
	}
			
}
