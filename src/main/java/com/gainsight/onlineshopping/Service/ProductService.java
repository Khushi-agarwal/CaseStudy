package com.gainsight.onlineshopping.Service;

import com.gainsight.onlineshopping.entity.Product;

import com.gainsight.onlineshopping.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
  


    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){return productRepository.findAll();
    }
   @Transactional
    public void addProducttoCart(int productId)
    {
        UserCart u=new UserCart(productId,1);
        userCartService.addCart(u);
    }
    @Transactional
    public void removeProductFromCart(int productId)
    {
        userCartService.deleteCart(productId);
    }
 

}
