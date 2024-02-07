package com.example;

import com.example.CustomerRepository;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {
	
	private final CustomerRepository customerRepository;
	public Main(CustomerRepository customerRepository) {
		
		this.customerRepository = customerRepository;
	}
	public static void main(String[] args)
	{
		//System.out.println("hello");
		
		SpringApplication.run(Main.class, args);
	}
	@GetMapping
	public List<Customer> getCustomers() {
		List<Customer> customers = customerRepository.findAll();
	    System.out.println("Retrieved customers: " + customers);
	    return customers;
	}
	    
	    record NewCustomerRequest(String name, String email, Integer age)
	    {
	    	
	    }
	    
	    @PostMapping
		
	 public void addCustomer(@RequestBody NewCustomerRequest request)
	 {
		 Customer customer=new Customer();
		 customer.setName(request.name());
		 customer.setEmail(request.email());
		 customer.setAge(request.age());
		 customerRepository.save(customer);
		 
	 }
	    
	    @DeleteMapping("{customerID}")
	    
	  public void deleteCustomer(@PathVariable("customerID") Integer id)
	  {
		  customerRepository.deleteById(id);
	  }
		
	@PatchMapping("{customerID}")
	public void updateCustomer(@PathVariable("customerID") Integer id
			,@RequestBody NewCustomerRequest request)
	{
	    Optional<Customer> optionalCustomer = customerRepository.findById(id);
	    
	    if(optionalCustomer.isPresent())
	    {
	    	Customer customer=optionalCustomer.get();
	    	customer.setAge(request.age());
	    	customer.setEmail(request.email());
	    	customer.setName(request.name());
	    	customerRepository.save(customer);
	    }

	}
	
	
}
	
	
	