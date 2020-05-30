/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

import com.afdemp.wellness.dao.OrderDao;
import com.afdemp.wellness.entities.Order$;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author giorgos
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private OrderDao odao;

    @Override
    public boolean createOrder(Order$ o) {
        return odao.createOrder(o);
    }

    @Override
    public List<Order$> getOrdersForCustomerById(int id) {
        return odao.getOrdersForCustomerById(id);
    }

    @Override
    public List<Order$> getPendingOrders() {
        return odao.getPendingOrders();
    }

    @Override
    public List<Order$> getDoneOrders() {
        return odao.getDoneOrders();
    }

    @Override
    public Order$ getOrderById(int id) {
        return odao.getOrderById(id);
    }

    @Override
    public boolean deleteOrderById(int id) {
        return odao.deleteOrderById(id);
    }

    @Override
    public boolean updateOrder(Order$ o) {
        return odao.updateOrder(o);
    }
    
}
