package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.PurchaseDetails;


public class PurchaseDetailsDaoImp extends AbstractDao<Integer,PurchaseDetails> implements IPurchaseDetailsDao{
    
    @Override
    public boolean updatePurchaseDetails(PurchaseDetails purchaseDetails){
        try {
            update(purchaseDetails);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
    
}
