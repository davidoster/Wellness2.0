package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.OrderDetails;


public class OrderDetailsDaoImp extends AbstractDao<Integer,OrderDetails> implements OrderDetailsDao{
    
    @Override
    public boolean updateOrderDetails(OrderDetails od){
        try {
            update(od);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
    
}
