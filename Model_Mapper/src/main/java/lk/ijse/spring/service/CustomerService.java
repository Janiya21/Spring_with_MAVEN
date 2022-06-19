package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerService {
    void saveCustomer(CustomerDTO entity);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO entity);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO> getAllCustomers();
}
