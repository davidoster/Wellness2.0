package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Product;
import com.afdemp.wellness.entities.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("cdao")
@Transactional
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {
    
    
    @Override
    public boolean createCustomer(Customer c) {
        try {
            persist(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public int saveCustomer(Customer c){
            getSession().save(c);
            getSession().flush();
            return c.getCustomerId();
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("email", email));
        Customer c = (Customer) crit.uniqueResult();
        return c;
    }
    
 
    @Override
    public Customer getCustomerById(int id) {
        Customer c = (Customer) getByKey(id);
        return c;
    }

    @Override
    public boolean updateCustomer(Customer c) {
        try {
            update(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Customer getCustomerBySsoId(String ssoId) {
        String sqlQuery = "select c from Customer c inner join c.userList u where u.ssoId ='" + ssoId + "'";
        Customer c =(Customer)getSession().createQuery(sqlQuery).uniqueResult();
        return c;
    }
    
    public List<Customer> getAllCustomers(){
        Criteria criteria = createEntityCriteria();
        List<Customer> customers = (List<Customer>) criteria.list();
        return customers;
    }
    
    @Override
    public List<Customer> getAllRegisteredCustomers(){
        String query = "select c from Customer c right join c.userList";
        List<Customer> registeredCustomers = (List<Customer>)getSession().createQuery(query).list();
        return registeredCustomers;
    }
    
    public boolean deleteCustomerById(int id){
        try{
            Customer c = getCustomerById(id);
            delete(c);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @Override
    public Customer getCustomerByUserId(int id){
        String sqlQuery = "select c from Customer c inner join c.userList u where u.id =" + id;
        Customer c =(Customer)getSession().createQuery(sqlQuery).uniqueResult();
        return c;
    }
    
    @Override
    public boolean isRegisteredUser(Customer c){
        UserDaoImpl udi = new UserDaoImpl();
        User u = udi.getAccountByCustomomerId(c.getCustomerId());
        return u!=null;
    }
    
    
    
}
