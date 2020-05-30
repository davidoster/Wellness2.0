package com.afdemp.wellness.controllers;

import com.afdemp.wellness.dao.CustomerDao;
import com.afdemp.wellness.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/xxx")
public class test {

    @Autowired
    CustomerDao cdao;

    @RequestMapping(method = RequestMethod.GET)
    public String Testing(ModelMap model) {
        Customer c = cdao.getCustomerByEmail("val@val.gr");
        model.addAttribute("variable",c);
        return "testview";
    }
}
