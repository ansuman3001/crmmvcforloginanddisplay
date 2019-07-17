package com.lti.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.crm.model.Customer;
import com.lti.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")

public class CustomerController
{
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/showForm")
		public String showFormForAdd(ModelMap theModel)
		{
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-forms";
	    }
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer)
	{
		customerservice.saveCustomer(thecustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/list")
		public String listCustomers(ModelMap theModel)
		{
			List<Customer> theCustomer = customerservice.getCustomers();
			theModel.addAttribute("customers", theCustomer);
			return "list-customers";
		}
	}
	
	


