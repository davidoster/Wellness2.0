
package com.afdemp.wellness.service;

import com.afdemp.wellness.entities.Customer;
import java.util.List;

public interface CustomerService {
    
    public boolean createCustomer(Customer c);
    
    public int saveCustomer(Customer c);
    
    public Customer getCustomerByEmail(String email);
    
    public Customer getCustomerById(int id);

    public boolean updateCustomer(Customer c);
    
    public boolean isEmailUnique(Integer id, String email);
    
    public Customer getCustomerBySsoId(String ssoId);
    
    public Customer updateCustomer(Customer newCustomer, Customer oldCustomer);
    
    public List<Customer> getAllCustomers();
    
    public boolean deleteCustomerById(int id);
}
