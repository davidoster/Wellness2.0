package com.afdemp.wellness.controllers;

import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Product;
import com.afdemp.wellness.service.AppService;
import com.afdemp.wellness.service.CustomerService;
import com.afdemp.wellness.service.ProductsService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.afdemp.wellness.service.IPurchaseService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AppService appService;

    @Autowired
    ProductsService productService;

    @Autowired
    CustomerService customerService;

    @Autowired
    IPurchaseService purchaseService;

 
}
