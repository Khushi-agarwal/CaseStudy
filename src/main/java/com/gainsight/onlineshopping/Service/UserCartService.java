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



    @Transactional(readOnly = true)
    public List<UserCart> getAllCart(){
        return userCartRepository.findAll();
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
  

}
