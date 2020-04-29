package shop.customers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.customers.service.CustomerDTO;
import shop.customers.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customer) {
		customerService.addCustomer(customer);
		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}

	@GetMapping("/customer/{customerNumber}")
	public ResponseEntity<?> getCustomer(@PathVariable String customerNumber) {
		 return new ResponseEntity<CustomerDTO>(customerService.getCustomer(customerNumber),HttpStatus.OK);
	}
}
