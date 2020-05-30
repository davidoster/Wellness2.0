/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

import com.afdemp.wellness.dao.CustomerDao;
import com.afdemp.wellness.dao.CustomerDaoImpl;
import com.afdemp.wellness.entities.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author samsung np350
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao cdao;

    @Override
    public boolean createCustomer(Customer c) {
        return true;
    }
    
    @Override
    public int saveCustomer(Customer c){
        return cdao.saveCustomer(c);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return cdao.getCustomerByEmail(email);
    }

    @Override
    public Customer getCustomerById(int id) {
        return cdao.getCustomerById(id);
    }

    @Override
    public boolean updateCustomer(Customer c) {
        return cdao.updateCustomer(c);
    }

    public boolean isEmailUnique(Integer id, String email) {
        Customer customer = getCustomerByEmail(email);
        return ( customer == null || ((id != null) && (customer.getCustomerId() == id)));
    }
    
    @Override
    public Customer getCustomerBySsoId(String ssoId){
        return cdao.getCustomerBySsoId(ssoId);
    }
    
    /**
     * This method updates an existing customer, and if succeeds it returns
     * the updated customer. It it fails it returns null. It updates the Address,
     * First name, Last name and Phone number.
     * @param newCustomer
     * @param oldCustomer
     * @return 
     */
    @Override
    public Customer updateCustomer(Customer newCustomer, Customer oldCustomer) {
        oldCustomer.setAddress(newCustomer.getAddress());
        oldCustomer.setFname(newCustomer.getFname());
        oldCustomer.setLname(newCustomer.getLname());
        oldCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
        if(cdao.updateCustomer(oldCustomer)) {
            return cdao.getCustomerById(oldCustomer.getCustomerId());
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return cdao.getAllCustomers();
    }

    @Override
    public boolean deleteCustomerById(int id) {
        return cdao.deleteCustomerById(id);
    }
}
