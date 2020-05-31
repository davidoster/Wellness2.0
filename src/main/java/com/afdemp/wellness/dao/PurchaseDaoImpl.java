package com.afdemp.wellness.dao;
import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Purchase;
import com.afdemp.wellness.entities.PurchaseDetails;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("purchaseDao")
@Transactional
public class PurchaseDaoImpl extends AbstractDao<Integer,Purchase> implements IPurchaseDao {
    
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
    public List<Purchase> getPurchasesForCustomerById(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("customer.customerId", id));
        List<Purchase> list = (List<Purchase>) crit.list();
        for ( Purchase p : list){
            Hibernate.initialize(p.getPurchaseDetailsList());
        } 
        return list;
    }
    
    @Override
    public List<Purchase> getPendingPurchases(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("pending", (short)1));
        List<Purchase> list = (List<Purchase>) crit.list();
        for ( Purchase p : list){
            Hibernate.initialize(p.getPurchaseDetailsList());
        } 
        return list;
    }
    
    @Override
    public List<Purchase> getDonePurchases(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("pending", (short)0));
        List<Purchase> list = (List<Purchase>) crit.list();
        for ( Purchase p : list){
            Hibernate.initialize(p.getPurchaseDetailsList());
        } 
        return list;
    }
    
    @Override
    public Purchase getPurchaseById(int id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("purchaseId", id));
        Purchase purchase = (Purchase) crit.uniqueResult();
        Hibernate.initialize(purchase.getPurchaseDetailsList());
        return purchase;
    }
    
    
    
    public boolean deletePurchaseById(int id){
        Purchase purchase= getPurchaseById(id);
        try{
            delete(purchase);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public boolean updatePurchase(Purchase purchase){
        try {
            update(purchase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
