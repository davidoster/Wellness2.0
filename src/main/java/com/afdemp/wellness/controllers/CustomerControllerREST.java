
package com.afdemp.wellness.controllers;

import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Order$;
import com.afdemp.wellness.service.AppService;
import com.afdemp.wellness.service.CustomerService;
import com.afdemp.wellness.service.OrderService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/api")
public class CustomerControllerREST {

    @Autowired
    AppService appService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService csrv;

    @Autowired
    OrderService osrv;

    @RequestMapping(value = {"/orders"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getOrders() {
        Map<String, Object> response = new HashMap();
        Customer customer = csrv.getCustomerBySsoId(appService.getPrincipal());
        List<Order$> orders = osrv.getOrdersForCustomerById(customer.getCustomerId());
        response.put("orders", orders);

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
