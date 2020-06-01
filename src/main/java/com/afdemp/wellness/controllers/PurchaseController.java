package com.afdemp.wellness.controllers;

import com.afdemp.wellness.dao.ProductDao;
import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Purchase;
import com.afdemp.wellness.entities.PurchaseDetails;
import com.afdemp.wellness.entities.Product;
import com.afdemp.wellness.service.AppService;
import com.afdemp.wellness.service.CustomerService;
import com.afdemp.wellness.service.ProductsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.afdemp.wellness.dao.IPurchaseDao;
import com.afdemp.wellness.service.IPurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    
    @Autowired
    AppService appService;

    @Autowired
    CustomerService customerService;
    
    @Autowired
    IPurchaseService purchaseService;

    @Autowired
    ProductsService productService;
    
    @Autowired
    ProductDao pdao;

    @Autowired
    IPurchaseDao odao;

    @RequestMapping(value = {"/buy/{id}"}, method = RequestMethod.GET)
    public String newPurchase(ModelMap model, @PathVariable int id) {
        Customer c;
        boolean isRegistered;
        String username = appService.getPrincipal();
        if (username == "anonymousUser") {
            c = new Customer();
            isRegistered = false;
        } else {
            c = customerService.getCustomerBySsoId(username);
            isRegistered = true;
        }
        Purchase p = new Purchase();
        Product p = productService.getProductById(id);
        

        List<PurchaseDetails> list = new ArrayList();
        o.setPurchaseDetailsList(list);

        
        PurchaseDetails odetails = new PurchaseDetails();
        purchaseDetails.setProduct(p);
//      list.add(odetails);
//        System.out.println("purchaseDetailsList:"+ list);

        o.addPurchaseDetailsToList(odetails);
        o.setCustomer(c);
        o.setPending((short) 1);
//     
        model.addAttribute("purchase", p);
        model.addAttribute("action", "purchase/save");
        model.addAttribute("registered", isRegistered);
        model.addAttribute("loggedinuser", appService.getPrincipal());
        return "buynow";
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public String newPurchase(@ModelAttribute("order") Purchase purchase,
            @RequestParam(value = "pid", required = false) List<Integer> pid,
            @RequestParam(value = "quantity", required = false) List<Integer> quantity,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("message", "problem");
            model.addAttribute("loggedinuser", appService.getPrincipal());
            return "homepage";
        }
        
       
        if (purchase.getId() == null) {
            Customer c = purchase.getCustomer();
            // If the customer buys as a visitor, he has null id
            if (c.getCustomerId() == null) {
               
                Customer existingCustomer = customerService.getCustomerByEmail(c.getEmail());
                if (existingCustomer != null) {                                               
                    existingCustomer = customerService.updateCustomer(c, existingCustomer);  
                    c.setCustomerId(existingCustomer.getCustomerId());                       
                } else {
                    c.setCustomerId(customerService.saveCustomer(c));                  
                    purchase.setCustomer(c);
                }
            }
            //set purchase time
            Date date = new Date(System.currentTimeMillis());
            purchase.setDate(date);
            // create a list of details
            int orderLength = pid.size();
            List<PurchaseDetails> list = new ArrayList();
            PurchaseDetails od;
            for (int i = 0; i < purchaseLength; i++) {
                od = new PurchaseDetails();
                od.setPurchase(purchase);
                list.add(od);
            }
            // link the list with the purchase 
            purchase.setPurchaseDetailsList(list);
            // for every element in the list of purchase details we have to set the product and the quantity
            // theoretically we have a list of products and a list of quantities from the requests param
            // so this code might be expandable for an order with multiple products
            // for now it has only been tested with one
            Product p;
            int q;
//            for (int i = 0; i < orderLength; i++) {
//                p = productService.getProductById(pid.get(i));
//                q = quantity.get(i);
//                order.getPurchaseDetailsList().get(i).setProduct(p);
//                order.getPurchaseDetailsList().get(i).setQuantity(q);
//                p.setStock(p.getStock() - q);
//                productService.updateProduct(p);
//            }
            boolean created = purchaseService.createPurchase(purchase);
            if (created) {
                model.addAttribute("customerName", purchase.getCustomer().getFirstName());
                model.addAttribute("purchaseNumber", purchase.getId());     
                model.addAttribute("update", false);
                model.addAttribute("loggedinuser", appService.getPrincipal());
            } else {
                model.addAttribute("message", "Sorry, a problem occured.");
                model.addAttribute("update", false);
                model.addAttribute("failure", true);
                model.addAttribute("loggedinuser", appService.getPrincipal());
            }

            return "purchase_success";
            /**
             * If Purchase Id is NOT null, then an existing order is updated
             * by the administrator.
             */
        } else {
            Customer c = purchase.getCustomer();
            Customer existingCustomer = customerService.getCustomerById(c.getCustomerId());
            if(!(c.equals(existingCustomer))) {
                existingCustomer = customerService.updateCustomer(c, existingCustomer);
                purchase.setCustomer(existingCustomer);
            }
            
            if(orderService.updatePurchase(purchase)) {
                model.addAttribute("message", "The purchase was updated successfully");
                model.addAttribute("update", true);
                model.addAttribute("loggedinuser", appService.getPrincipal());
                return "purchase_success";
            } else {
                model.addAttribute("message", "Sorry, the order failed to update.");
                model.addAttribute("update", true);
                model.addAttribute("loggedinuser", appService.getPrincipal());
                return "purchase_success";
            }
        }
    }


    
}
