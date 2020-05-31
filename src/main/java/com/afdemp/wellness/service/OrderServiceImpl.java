/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

import com.afdemp.wellness.entities.Purchase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.afdemp.wellness.dao.IPurchase;

/**
 *
 * @author giorgos
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private Purchase odao;

    @Override
    public boolean createOrder(Purchase o) {
        return odao.createOrder(o);
    }

    @Override
    public List<Purchase> getOrdersForCustomerById(int id) {
        return odao.getOrdersForCustomerById(id);
    }

    @Override
    public List<Purchase> getPendingOrders() {
        return odao.getPendingOrders();
    }

    @Override
    public List<Purchase> getDoneOrders() {
        return odao.getDoneOrders();
    }

    @Override
    public Purchase getOrderById(int id) {
        return odao.getOrderById(id);
    }

    @Override
    public boolean deleteOrderById(int id) {
        return odao.deleteOrderById(id);
    }

    @Override
    public boolean updateOrder(Purchase o) {
        return odao.updateOrder(o);
    }
    
}
