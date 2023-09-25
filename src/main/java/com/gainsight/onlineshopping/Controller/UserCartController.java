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


    @PostMapping(consumes = "application/json")
    public void addCart(UserCart userCart)
    {
        userCartService.addCart(userCart);
    }
    @DeleteMapping
    public HttpStatus deleteCart( int productId)
    {
        if(userCartService.deleteCart(productId))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<UserCart>> getAllProducts()
    {
        return new ResponseEntity<List<UserCart>>(userCartService.getAllCart(),HttpStatus.OK);

    }

    @GetMapping("/increase/{productId}")
    @CrossOrigin
    public ResponseEntity<Integer> increase(@PathVariable int productId)
    {
       int x= userCartService.increase(productId);
       if(x!=-1)
           return ResponseEntity.ok(x);
       return ResponseEntity.notFound().build();
    }
    @GetMapping("/decrease/{productId}")
    @CrossOrigin
    public ResponseEntity<Integer> decrease(@PathVariable int productId)
    {
        int x=userCartService.decrease(productId);
        if(x!=-1)
            return ResponseEntity.ok(x);
        return ResponseEntity.notFound().build();
    }

}
