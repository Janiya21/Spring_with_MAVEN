package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

@RestController
@RequestMapping("customer")
@CrossOrigin
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
    public ArrayList<CustomerDTO> getAllCustomers(){
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("C001","Janith","Jani@gmail.com","0112509821"));
        customerDTOS.add(new CustomerDTO("C002","Dasun","Dassa@gmail.com","011232821"));
        return customerDTOS;
    }

    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    public boolean saveCustomer(HttpServletRequest req, @ModelAttribute CustomerDTO dto) throws IOException {

        /*String customerId = req.getParameter("customerId");
        String customerName = req.getParameter("customerName");
        String customerEmail = req.getParameter("customerEmail");
        String customerTelNo = req.getParameter("customerTelNo");

        System.out.println(customerId + " " + customerName + " " + customerEmail + " " + customerTelNo);*/

        System.out.println(dto.toString());

        return true;
    }

    @GetMapping(path = {"/{id}"})
    public CustomerDTO searchCustomer(@PathVariable String id){
        return new CustomerDTO(id,"xxxxxxxx","xx@xx.com","+94 xxxxxxxxx");
    }

    @DeleteMapping(params = {"id"})
    public boolean deleteCustomer(String id){
        System.out.println("Delete ID " + id);

        return true;
    }

    @PutMapping(consumes = {"application/json"}, produces = "application/json")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO dto){
        System.out.println(dto.toString());
        return dto;
    }

}
