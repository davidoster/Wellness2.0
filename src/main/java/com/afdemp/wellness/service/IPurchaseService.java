/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.wellness.service;

import com.afdemp.wellness.entities.Purchase;
import java.util.List;


public interface IPurchaseService {
    
    public boolean createPurchase(Purchase purchase);
    
    public List<Purchase> getPurchasesForCustomerById(int id);
    
    public List<Purchase> getPendingPurchases();
    
    public List<Purchase> getDonePurchases();
    
    public Purchase getPurchaseById(int id);
    
    public boolean deletePurchaseById(int id);
   
    public boolean updatePurchase(Purchase purchase);

}
