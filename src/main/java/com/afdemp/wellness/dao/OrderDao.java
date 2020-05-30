package com.afdemp.wellness.dao;
import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Order$;
import com.afdemp.wellness.entities.OrderDetails;
import java.util.List;


public interface OrderDao {
    
    public boolean createOrder(Order$ o);
    
    public List<Order$> getOrdersForCustomerById(int id);
    
    public List<Order$> getPendingOrders();
    
    public List<Order$> getDoneOrders();
    
    public Order$ getOrderById(int id); 
    
    public boolean deleteOrderById(int id);
    
    public boolean updateOrder(Order$ o);
    
    
    
    
}
