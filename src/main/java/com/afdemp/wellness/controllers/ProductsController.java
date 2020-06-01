package com.afdemp.wellness.controllers;

import com.afdemp.wellness.entities.Product;
import com.afdemp.wellness.service.AppService;
import com.afdemp.wellness.service.ProductsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/products")
@SessionAttributes("roles")
public class ProductsController {
    
    @Autowired
    AppService appService;

    @Autowired
    ProductsService productsService;    
      
    @RequestMapping(value = {"", "/", "/{something}"}, method = RequestMethod.GET)
    public String getProductsOfCategory(ModelMap model, @ModelAttribute("message") String message) {
        model.addAttribute("message", message);
        model.addAttribute("pagetitle", "Products");
        model.addAttribute("loggedinuser", appService.getPrincipal());        
        return "view_product_details";
    }
    
    @RequestMapping (value = { "/", "/productsList"}, method = RequestMethod.GET)
    public String getAllProducts(ModelMap view){
        List<Product> products = productsService.getAllProducts();
        view.addAttribute("products", products);
        return "listofproducts";
    
}
    

}
