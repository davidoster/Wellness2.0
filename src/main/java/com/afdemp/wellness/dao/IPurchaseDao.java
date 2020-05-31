package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.Purchase;
import java.util.List;


public interface IPurchaseDao {
    
    public boolean createPurchase(Purchase purchase);
    
    public List<Purchase> getPurchasesForCustomerById(int id);
    
    public List<Purchase> getPendingPurchases();
    
    public List<Purchase> getDonePurchases();
    
    public Purchase getPurchaseById(int id); 
    
    public boolean deletePurchaseById(int id);
    
    public boolean updatePurchase(Purchase purchase);
    
    
    
    
}
