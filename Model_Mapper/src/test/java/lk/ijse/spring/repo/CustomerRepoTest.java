package lk.ijse.spring.repo;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveCustomer(){
        customerRepo.save(new Customer("C001","Janith","Jani@gmail.com","0734323239"));
        customerRepo.save(new Customer("C002","Sandaru","Sandaru@gmail.com","0733423239"));
        customerRepo.save(new Customer("C003","Dissa","Dissa@gmail.com","0734322339"));
    }

    @Test
    public void getAllCustomers(){
        List<Customer> all = customerRepo.findAll();
        for (Customer customer : all) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void searchCustomer(){
        Optional<Customer> id = customerRepo.findById("C001");
        boolean present = id.isPresent();
        System.out.println(present);

        Customer customer = id.get();
        System.out.println(customer.toString());
    }

    @Test
    public void deleteCustomer() {
        customerRepo.deleteById("C001");
    }

    @Test
    public void updateCustomer(){
        if (customerRepo.existsById("C002")) {
            Customer customer1 = new Customer("C002", "Dasuni", "Dasuni@email.com", "0798192817");
            customerRepo.save(customer1);
        }else{
            throw new RuntimeException("No Such Customer To Update");
        }

    }

    @Test
    void searchCustomerByName() {
        Customer customerByName = customerRepo.findCustomerByName("Janith");
        System.out.println(customerByName.toString());
    }

    @Test
    public void searchCustomerByAddress(){
        Customer c1 = customerRepo.findCustomerByAddress("Kaluthara");
        System.out.println(c1.toString());
    }

    @Test
    public void searchCustomerByNameAndAddress(){
        Customer c1 = customerRepo.findCustomerByNameAndAddress("Kasun","Kaluthara");
        System.out.println(c1.toString());
    }

    @Test
    public void t1(){
        Customer c1 = customerRepo.findByName("Dasun");
        System.out.println(c1.toString());

        Customer c2 = customerRepo.readByName("Dasun");
        System.out.println(c2.toString());

        Customer c3 = customerRepo.getByName("Dasun");
        System.out.println(c3.toString());

        Customer c4 = customerRepo.queryByName("Dasun");
        System.out.println(c4.toString());

        Customer c5 = customerRepo.searchByName("Kasun");
        System.out.println(c5.toString());

        Customer c6 = customerRepo.streamByName("Kasun");
        System.out.println(c6.toString());
    }

}