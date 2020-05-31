package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.PurchaseDetails;


public class OrderDetailsDaoImp extends AbstractDao<Integer,PurchaseDetails> implements OrderDetailsDao{
    
    @Override
    public boolean updateOrderDetails(PurchaseDetails od){
        try {
            update(od);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
    
}
