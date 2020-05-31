package com.afdemp.wellness.dao;

import com.afdemp.wellness.entities.Purchase;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("odao")
@Transactional
public class PurchaseDaoImpl extends AbstractDao<Integer, Purchase> implements IPurchase {
    
    @Override
    public boolean createPurchase(Purchase purchase){
        try {
            persist(purchase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public List<> getPurchaseForCustomerById(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("customer.customerId", id));
        List<> list = (List<>) crit.list();
        for (  p : list){
            Hibernate.initialize(o.getOrderDetailsList());
        } 
        return list;
    }
    
    @Override
    public List<> getPendingPurchases(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("pending", (short)1));
        List<> list = (List<>) crit.list();
        for (  p : list){
            Hibernate.initialize(p.getOrderDetailsList());
        } 
        return list;
    }
    
    @Override
    public List<> getDonePurchases(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("pending", (short)0));
        List<> list = (List<>) crit.list();
        for (  p : list){
            Hibernate.initialize(p.getOrderDetailsList());
        } 
        return list;
    }
    
    @Override
    public  getPurchaseById(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("purchaseId", id));
         purchase = () crit.uniqueResult();
        Hibernate.initialize(purchase.getPurchaseDetailsList());
        return purchase;
    }
    
    
    
    public boolean deleteOrderById(int id){
         purchase = getPurchaseById(id);
        try{
            delete(purchase);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean updatePurchase( purchase){
        try {
            update(purchase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
