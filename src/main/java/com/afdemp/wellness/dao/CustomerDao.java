package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.Customer;
import java.util.List;


public interface CustomerDao {
    
    public boolean createCustomer(Customer c);
    
    public int saveCustomer(Customer c);
    
    public Customer getCustomerByEmail(String email);
    
    public Customer getCustomerById(int id);

    public boolean updateCustomer(Customer c);
    
    public Customer getCustomerBySsoId(String ssoId);
    
    public List<Customer> getAllRegisteredCustomers();
    
    public List<Customer> getAllCustomers();
    
    public Customer getCustomerByUserId(int id);
    
    public boolean isRegisteredUser(Customer c);
    
    public boolean deleteCustomerById(int id);
    
}
