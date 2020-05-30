package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.Customer;
import java.util.List;

import com.afdemp.wellness.entities.User;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();
        
        ///// Extra //////////////
        
        //public boolean createAccount(User u); // einai to save stin ousia
        
        public User getAccountByCustomomerId(int id);
        
        public boolean updateAccount(User u);
        
        public boolean deleteAccountByCustomerId(int id);

}

