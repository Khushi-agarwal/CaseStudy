package com.gainsight.onlineshopping.Controller;

import com.gainsight.onlineshopping.Service.ProductService;
import com.gainsight.onlineshopping.entity.Product;

//import com.sun.org.apache.bcel.internal.generic.ClassGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
//Model model;
    @Autowired
    ProductService productService;

   @GetMapping
   @CrossOrigin
    public ResponseEntity<List<Product>> getAllProducts()
    {
       return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);

    }
    @GetMapping(value="/add/{productId}")
    @CrossOrigin
    public void addButton(@PathVariable int productId)
    {
        productService.addProducttoCart(productId);
    }
    @GetMapping(value="/delete/{productId}")
    @CrossOrigin
    public void deleteButton(@PathVariable int productId)
    {
        productService.removeProductFromCart(productId);
    }


    @GetMapping(value="/search/{productName}")
    @CrossOrigin
    public ResponseEntity<List<Product>> getsearch(@PathVariable String productName)
    {

        return new ResponseEntity<List<Product>>(productService.getSearch(productName),HttpStatus.OK);
    }

}
