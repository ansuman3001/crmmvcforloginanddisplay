package com.lti.crm.service;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.crm.model.Customer;
@Repository

public interface CustomerService 
{
public void saveCustomer(Customer theCustomer);

public List<Customer> getCustomers();
public Customer getCustomer(int theId);
}
