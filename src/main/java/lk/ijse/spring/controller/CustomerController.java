package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@RequestMapping("customer")
public class CustomerController {

    /*@GetMapping(consumes = "text/html",produces = "application/json")
    public CustomerDTO testMethodOne(){
        return new CustomerDTO("C001","Text","Panadura",1000);
    }

    @GetMapping(consumes = "application/json",produces = "application/json")
    public CustomerDTO testMethodTwo(){
        return new CustomerDTO("C002","JSON","Panadura",1000);
    }

    @GetMapping(headers = {"Content-Type=text/css","Accept=application/json"})
    public CustomerDTO testMethodThree(){
        return new CustomerDTO("C003","JSON","Panadura",1000);
    }*/

    @GetMapping(produces = "application/json")
    public CustomerDTO getAllCustomers(HttpServletRequest request, HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","DELETE,PUT");
        response.addHeader("Access-Control-Allow-Headers","Content-Type");

        return new CustomerDTO("C001","Janith","Jani@gmail.com","0112509821");
    }

}
