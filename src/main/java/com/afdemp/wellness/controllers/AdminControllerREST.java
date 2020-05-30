package com.afdemp.wellness.controllers;

import com.afdemp.wellness.entities.Order$;
import com.afdemp.wellness.service.OrderService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/api")
public class AdminControllerREST {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = {"/orders/{something}"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getOrders(@PathVariable String something) {

        List<Order$> orders = new ArrayList();
        Map<String, Object> response = new HashMap();

        switch (something) {
            case "pending":
                orders = orderService.getPendingOrders();
                // JSON https://api.myjson.com/bins/tjez1
                break;
            case "done":
                orders = orderService.getDoneOrders();
                // JSON https://api.myjson.com/bins/6z359
                break;
            default:
                try {
                    Order$ o = orderService.getOrderById(Integer.parseInt(something));
                    // JSON https://api.myjson.com/bins/1d8v3h
                    orders.add(o);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                } finally {
                    break;
                }
        }

        response.put("orders", orders);

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
