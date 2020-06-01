package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.Customer;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.afdemp.wellness.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {


    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
   

    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getUserProfileList());
        }
        return user;
    }
    

    public User findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getUserProfileList());
        }
        return user;
    }
    

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        for (User user : users) {
            Hibernate.initialize(user.getUserProfileList());
        }
        return users;
    }
  
    public void save(User user) {
        persist(user);
    }
   

    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User) crit.uniqueResult();
        delete(user);
    }

   
    @Override
    public User getAccountByCustomomerId(int id) {

        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("customer.customerId", id));
        User user = (User) crit.uniqueResult();
        return user;
    }

  
    @Override
    public boolean updateAccount(User u) {
        try {
            update(u);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteAccountByCustomerId(int id) {
        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("customer.customerId", id));
            User user = (User) crit.uniqueResult();
            delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
