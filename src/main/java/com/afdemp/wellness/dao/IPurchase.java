package com.afdemp.wellness.dao;

import java.util.List;


public interface IPurchase {
    
    public boolean createPurchase(IPurchase purchase);
    
    public List<IPurchase> getPurchasesForCustomerById(int id);
    
    public List<IPurchase> getPendingPurchases();
    
    public List<IPurchase> getDoneOrders();
    
    public IPurchase getPurchaseById(int id); 
    
    public boolean deletePurchaseById(int id);
    
    public boolean updatePurchase(IPurchase purchase);
    
    
    
    
}
