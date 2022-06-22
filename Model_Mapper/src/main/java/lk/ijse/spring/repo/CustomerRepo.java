package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findCustomerByName(String name);

    Customer findCustomerByAddress(String address);

    Customer findCustomerByNameAndAddress(String name, String address);

    Customer findByName(String name);

    Customer readByName(String name);

    Customer getByName(String name);

    Customer queryByName(String name);

    Customer searchByName(String name);

    // If there is only one record you can set the return type as follow
    Customer streamByName(String name);

    //------------------------------------------------------------------



}
