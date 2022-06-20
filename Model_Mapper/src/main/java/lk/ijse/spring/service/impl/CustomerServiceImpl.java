package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            //Customer customer = new Customer(dto.getId(),dto.getName(),dto.getEmail(),dto.getTelNo());
            repo.save(mapper.map(dto,Customer.class));
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }

    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getId())) {
            // Customer customer = new Customer(dto.getId(),dto.getName(),dto.getEmail(),dto.getTelNo());
            repo.save(mapper.map(dto,Customer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }

    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (repo.existsById(id)){
            Customer entity = repo.findById(id).get();
            // return new CustomerDTO(entity.getId(),entity.getName(),entity.getAddress(),entity.getTelNo());
            return mapper.map(entity,CustomerDTO.class);
        }else{
            throw new RuntimeException("No Customer For "+id+" ..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer cus : all) {
            // customerDTOS.add(new CustomerDTO(cus.getId(),cus.getName(),cus.getAddress(),cus.getTelNo()));
            customerDTOS.add(mapper.map(cus,CustomerDTO.class));
        }
        return customerDTOS;
    }
}
