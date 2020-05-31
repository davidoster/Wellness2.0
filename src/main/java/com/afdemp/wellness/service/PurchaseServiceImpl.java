
package com.afdemp.wellness.service;

import com.afdemp.wellness.entities.Purchase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.afdemp.wellness.dao.IPurchaseDao;


@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements IPurchaseService{
    
    @Autowired
    private IPurchaseDao dao;

    @Override
    public boolean createPurchase(Purchase o) {
        return dao.createPurchase(o);
    }

    @Override
    public List<Purchase> getPurchasesForCustomerById(int id) {
        return dao.getPurchasesForCustomerById(id);
    }

    @Override
    public List<Purchase> getPendingPurchases() {
        return dao.getPendingPurchases();
    }

    @Override
    public List<Purchase> getDonePurchases() {
        return dao.getDonePurchases();
    }

    @Override
    public Purchase getPurchaseById(int id) {
        return dao.getPurchaseById(id);
    }

    @Override
    public boolean deletePurchaseById(int id) {
        return dao.deletePurchaseById(id);
    }

    @Override
    public boolean updatePurchase(Purchase purchase) {
        return dao.updatePurchase(purchase);
    }
    
}
