package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /*@GetMapping(produces = "application/json")
    public ArrayList<CustomerDTO> getAllCustomers(){
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("C001","Janith","Jani@gmail.com","0112509821"));
        customerDTOS.add(new CustomerDTO("C002","Dasun","Dassa@gmail.com","011232821"));
        return customerDTOS;
    }

    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    public boolean saveCustomer(HttpServletRequest req, @ModelAttribute CustomerDTO dto) throws IOException

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
    }*/

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200,"Ok",customerService.getAllCustomers());
    }

    //@ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customer) {
        customerService.saveCustomer(customer);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customer) {
        customerService.updateCustomer(customer);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",customerService.searchCustomer(id));
    }

}
