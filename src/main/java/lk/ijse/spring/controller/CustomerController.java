package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getAllCustomers(){
        return new CustomerDTO("C001","Janith","Colombo",120000);
    }

    @GetMapping(consumes = "text/html",produces = "application/json")
    public CustomerDTO testMethodOne(){
        return new CustomerDTO("C001","Text","Panadura",1000);
    }




}
