package com.gainsight.onlineshopping.Controller;

import com.gainsight.onlineshopping.Service.UserCartService;
import com.gainsight.onlineshopping.entity.Product;
import com.gainsight.onlineshopping.entity.UserCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class UserCartController {
    @Autowired
    UserCartService userCartService;


 
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<UserCart>> getAllProducts()
    {
        return new ResponseEntity<List<UserCart>>(userCartService.getAllCart(),HttpStatus.OK);

    }

   
}
