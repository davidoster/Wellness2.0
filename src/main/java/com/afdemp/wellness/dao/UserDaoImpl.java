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

//        private static SessionFactory sessionFactory;
//        private Session session;
    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    //Tested --> Works fine !! Make sure to initialize nested lists in customer field if you have to
    //Explanation: User contains UserProfileList (Lazily initialized) and a Customer object (contains lists that are Lazily initialized) and this Customer objects contains... etc etc
    //If the User toString prints all those objects you have to manually initialize them with the Hibernate.initialize method

    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getUserProfileList());
        }
        return user;
    }
    //Tested --> Works fine ! Again be aware of the nested Lazily initialized lists

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
    // Tested --> works fine ! Again the same

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
    // tested --> works

    public void save(User user) {
        persist(user);
    }
    // tested --> works

    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User) crit.uniqueResult();
        delete(user);
    }

    /////////////// Extra ////////
    // Tested --> Works fine !!
    @Override
    public User getAccountByCustomomerId(int id) {
//            Criteria crit = getSession().createCriteria(User.class);
//            Criteria suppCrit = crit.createCriteria("customer");
//            suppCrit.add(Restrictions.eq("customer.customerId",id));
//            User u = (User)crit.uniqueResult();
//            return u;
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("customer.customerId", id));
        User user = (User) crit.uniqueResult();
        return user;
    }

    // tested --> works
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
