package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.soap.Addressing;
import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    //add One Customer for testing
    public CustomerDTO addOneCustomer(String id) {
        //If it is a new Customer It should added to the database
        return new CustomerDTO(id, "Ramal", "Ramal@gmail.com", "0112329832");
    }

    //Add multiple customers for testing
    public void addCustomers(){
        CustomerDTO c1 = new CustomerDTO("C001", "Warner", "Warner@gmail.com", "0112329832");
        CustomerDTO c2 = new CustomerDTO("C002", "Pathum", "Pathum@gmail.com", "0712329999");
        CustomerDTO c3 = new CustomerDTO("C003", "Maheesh", "Maheesh@gmail.com", "0112399561");
        CustomerDTO c4 = new CustomerDTO("C004", "Finch", "Finch@gmail.com", "0786231989");
        customerService.saveCustomer(c1);
        customerService.saveCustomer(c2);
        customerService.saveCustomer(c3);
        customerService.saveCustomer(c4);
    }


    @Test
    void saveCustomer() {

        CustomerDTO customerDTO = addOneCustomer("C001");
        //Check there is no errors
        //If there are no errors test ok
        //If there are errors test is false
        assertDoesNotThrow(() -> {
            customerService.saveCustomer(customerDTO);
        });

        //===============================================

        // If the customer already exist. check if it is throwing the error
        CustomerDTO customerDTO2 =addOneCustomer("C001");

        //Check if there is a error. If there is a error test is ok
        //If there is no error test case false
        assertThrows(RuntimeException.class, () -> {
            customerService.saveCustomer(customerDTO2);
        });

    }

    @Test
    void deleteCustomer() {
        assertThrows(RuntimeException.class, () -> {
            customerService.deleteCustomer("C011");
        });
    }

    @Test
    void updateCustomer() {
        assertThrows(RuntimeException.class, () -> {
            customerService.updateCustomer(addOneCustomer("C011"));
        });
    }

    @Test
    void searchCustomer() {
        assertThrows(RuntimeException.class, () -> {
            customerService.searchCustomer("C011");
        });
    }


}