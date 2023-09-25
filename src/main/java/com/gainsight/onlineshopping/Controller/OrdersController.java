package com.gainsight.onlineshopping.Controller;

import com.gainsight.onlineshopping.Service.OrdersService;
import com.gainsight.onlineshopping.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
double tt=0.0;
    @CrossOrigin
    @PostMapping(consumes="application/json")
    public void addOrders(@RequestBody Orders orders)
    {
  tt= ordersService.addOrderDetails(orders);


    }

@CrossOrigin
    @GetMapping(value="/show")
    public ResponseEntity<List<Orders>> getAllOrders()
    {
        return new ResponseEntity<List<Orders>>(ordersService.getAllOrders(), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value="/totalamount")
    public ResponseEntity<Double> getTotalAmount()
    {
        return ResponseEntity.ok(tt);

    }

}
