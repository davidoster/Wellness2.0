/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

import com.afdemp.wellness.entities.Order$;
import java.util.List;

/**
 *
 * @author giorgos
 */
public interface OrderService {
    
    public boolean createOrder(Order$ o);
    
    public List<Order$> getOrdersForCustomerById(int id);
    
    public List<Order$> getPendingOrders();
    
    public List<Order$> getDoneOrders();
    
    public Order$ getOrderById(int id);
    
    public boolean deleteOrderById(int id);
   
    public boolean updateOrder(Order$ o);

}
