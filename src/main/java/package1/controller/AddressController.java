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

import package1.entity.Address;
import package1.entity.Employee;
import package1.service.AddressService;
import package1.service.EmployeeService;


@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Address> getAllAddresses(){
		return addressService.getAllAddresses();
	}
	
	@PostMapping
	public Address createNewAddress(@RequestBody Address address) {
		return addressService.createNewAddress(address);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAddress(@PathVariable int id) {
		return addressService.deleteAddress(id);
	}
	
	@PostMapping("/{id}/employees/{email}")
	public Address toEmployee(@PathVariable int id, @PathVariable String email) {
		return addressService.toEmployee(id, email);
		}
		
}
