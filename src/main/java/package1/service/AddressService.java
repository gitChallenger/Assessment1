package package1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import package1.entity.Address;
import package1.entity.Employee;
import package1.repository.AddressRepository;
import package1.repository.EmployeeRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	//Get all Addresses
	public List<Address> getAllAddresses(){
		return addressRepository.findAll();
	}
	
	//Create new Address
	public Address createNewAddress(Address address) {
		return addressRepository.save(address);
	}
		
	//Employee address relation
	public Address toEmployee(int id, String email) {
		Address ad = addressRepository.findById(id).get();
		Employee emp = employeeRepository.findById(email).get();
		ad.setEmployee(emp);
		return addressRepository.save(ad);	
	}
	
	//Delete address
	public String deleteAddress(int id) {
		addressRepository.deleteById(id);
		return "Deleted";
	}
}
