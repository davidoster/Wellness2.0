
package com.afdemp.wellness.controllers;

import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Purchase;
import com.afdemp.wellness.service.AppService;
import com.afdemp.wellness.service.CustomerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.afdemp.wellness.dao.IPurchase;


@Controller
@RequestMapping("/user")
@SessionAttributes("roles")
public class CustomerController {
    
    @Autowired
    AppService appService;

    @Autowired
    CustomerService customerService;
    
    @Autowired
    Purchase odao;
    
    @RequestMapping(value = {"/customers"}, method = RequestMethod.GET)
    public String getProfile(ModelMap model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String getProfile2(ModelMap model) {
        model.addAttribute("loggedinuser", appService.getPrincipal());
        model.addAttribute("customer", customerService.getCustomerBySsoId(appService.getPrincipal()));
        model.addAttribute("pagetitle", "My profile");
        model.addAttribute("adminForAdmin", false);
        return "customer_profile";
    }

    @RequestMapping(value = {"/profile/update"}, method = RequestMethod.GET)
    public String updateProfile(ModelMap model) {
        model.addAttribute("customer", customerService.getCustomerBySsoId(appService.getPrincipal()));
        model.addAttribute("action","/Wellness/user/profile/save");
        model.addAttribute("cancel","../Wellness/user/profile");
        model.addAttribute("loggedinuser", appService.getPrincipal());
        model.addAttribute("pagetitle", "Edit profile");
        return "updateprofile";
    }

    @RequestMapping(value = {"/profile/save"}, method = RequestMethod.POST)
    public String saveProfile(@Valid Customer customer, BindingResult result,
            ModelMap model, @RequestParam("oldemail") String oldemail) {

        if (result.hasErrors()) {
            model.addAttribute("loggedinuser", appService.getPrincipal());
            model.addAttribute("pagetitle", "Edit profile");
            return "updateprofile";
        }

        if (!oldemail.equals(customer.getEmail())) {
            if (!customerService.isEmailUnique(customer.getCustomerId(), customer.getEmail())) {
                model.addAttribute("emailnotUnique", "Email " + customer.getEmail()
                        + " already exists. Please fill in a different email.");
                model.addAttribute("loggedinuser", appService.getPrincipal());
                model.addAttribute("pagetitle", "Edit profile");
                return "updateprofile";
            }
        }

        if (customerService.updateCustomer(customer)) {
            model.addAttribute("success", "Your info was updated successfully.");
        } else {
            model.addAttribute("success", "Your info was not updated.");
        }
        model.addAttribute("loggedinuser", appService.getPrincipal());
        model.addAttribute("pagetitle", "My profile");
        return "customer_profile";
    }

    @RequestMapping(value = {"/profile/myorders"}, method = RequestMethod.GET)
    public String getOrders(ModelMap model) {
            String username = appService.getPrincipal();
            int id = customerService.getCustomerBySsoId(username).getCustomerId();
            List<Purchase> orders = odao.getOrdersForCustomerById(id);
            model.addAttribute("orders",orders);
            model.addAttribute("loggedinuser", appService.getPrincipal());
            model.addAttribute("pagetitle", "My orders");
        return "myorders";
    }
}
