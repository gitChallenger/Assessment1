package package1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import package1.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
