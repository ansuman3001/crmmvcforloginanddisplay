package com.lti.crm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.crm.model.Customer;

@Repository
public interface CustomerDAO 
{
public void saveCustomer(Customer theCustomer);

public List<Customer> getCustomers();

public Customer getCustomer(int theId);
}
