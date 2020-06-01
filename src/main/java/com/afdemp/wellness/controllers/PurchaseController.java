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

  
    
}
