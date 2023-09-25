package com.gainsight.onlineshopping.Service;

import com.gainsight.onlineshopping.entity.Product;
import com.gainsight.onlineshopping.entity.UserCart;
import com.gainsight.onlineshopping.repository.ProductRepository;
import com.gainsight.onlineshopping.repository.UserCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserCartService {
    @Autowired
    UserCartRepository userCartRepository;

@Autowired
ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<UserCart> getAllCart(){
        return userCartRepository.findAll();
    }
    @Transactional
    public void addCart(UserCart userCart)
    {
        userCartRepository.save(userCart);
    }
    @Transactional
    public boolean deleteCart(int productId)
    {
        long count=userCartRepository.count();
      userCartRepository.deleteById(productId);
        return count>userCartRepository.count();


    }
    @Transactional
    public int increase(int productId)
    {
       Optional<UserCart> op= userCartRepository.findById(productId);
        if(op.isPresent()) {
            op.get().setProductQuantity(op.get().getProductQuantity() + 1);
        userCartRepository.save(op.get());
        return op.get().getProductQuantity();}

        return -1;
    }
    @Transactional
    public int decrease(int productId)
    {
        Optional<UserCart> op=userCartRepository.findById(productId);
        if(op.isPresent()){
            if(op.get().getProductQuantity()==1)
                deleteCart(productId);
            else {
                op.get().setProductQuantity(op.get().getProductQuantity() - 1);
                userCartRepository.save(op.get());
                return op.get().getProductQuantity();
            }
        }
        return -1;
    }
    @Transactional(readOnly = true)
    public double getPriceFromProductId(int productId)
    {
      Optional<Product> product=  productRepository.findById(productId);
      if(product.isPresent())
          return product.get().getProductPrice();
      return 0;
    }
    @Transactional
    public void deleteAll()
    {
        userCartRepository.deleteAll();
    }


}
