package package1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import package1.entity.Employee;
import package1.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/byEmail/{email}")
	public Employee getEmployeeById(@PathVariable String email) {
		return employeeService.getEmployeeById(email);
	}
	
	@GetMapping("/byName/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}
	
	@PostMapping
	public Employee createNewEmployee(@RequestBody Employee employee) {
		return employeeService.createNewEmployee(employee);
	}
	
	@DeleteMapping("/{email}")
	public String deleteEmployee(@PathVariable String email) {
		return employeeService.deleteEmployee(email);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
}
