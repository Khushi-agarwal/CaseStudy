package com.gainsight.onlineshopping.Service;

import com.gainsight.onlineshopping.entity.Product;
import com.gainsight.onlineshopping.entity.UserCart;
import com.gainsight.onlineshopping.repository.ProductRepository;
import com.gainsight.onlineshopping.repository.UserCartRepository;
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
    @Autowired
    UserCartService userCartService;


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
//    @Transactional
//    public Product findProductById(int productId)
//    {
//        Optional<Product> op=productRepository.findById();
//    }

    @Transactional
    public List<Product> getSearch(String productName)
    {
       List<Product> p= productRepository.findByName(productName);
       return p;
    }

}
