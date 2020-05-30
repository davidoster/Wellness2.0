package com.afdemp.wellness.dao;
import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Order$;
import com.afdemp.wellness.entities.OrderDetails;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("odao")
@Transactional
public class OrderDaoImpl extends AbstractDao<Integer,Order$> implements OrderDao {
    
    @Override
    public boolean createOrder(Order$ o){
        try {
            persist(o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<Order$> getOrdersForCustomerById(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("customer.customerId", id));
        List<Order$> list = (List<Order$>) crit.list();
        for ( Order$ o : list){
            Hibernate.initialize(o.getOrderDetailsList());
        } 
        return list;
    }
    
    @Override
    public List<Order$> getPendingOrders(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("pending", (short)1));
        List<Order$> list = (List<Order$>) crit.list();
        for ( Order$ o : list){
            Hibernate.initialize(o.getOrderDetailsList());
        } 
        return list;
    }
    
    @Override
    public List<Order$> getDoneOrders(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("pending", (short)0));
        List<Order$> list = (List<Order$>) crit.list();
        for ( Order$ o : list){
            Hibernate.initialize(o.getOrderDetailsList());
        } 
        return list;
    }
    
    @Override
    public Order$ getOrderById(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("orderId", id));
        Order$ o = (Order$) crit.uniqueResult();
        Hibernate.initialize(o.getOrderDetailsList());
        return o;
    }
    
    
    
    public boolean deleteOrderById(int id){
        Order$ o = getOrderById(id);
        try{
            delete(o);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean updateOrder(Order$ o){
        try {
            update(o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
