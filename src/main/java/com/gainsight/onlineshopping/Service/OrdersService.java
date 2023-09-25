package com.gainsight.onlineshopping.Service;

import com.gainsight.onlineshopping.entity.Orders;
import com.gainsight.onlineshopping.entity.UserCart;
import com.gainsight.onlineshopping.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    UserCartService userCartService;

@Transactional
public double addOrderDetails(Orders orders) {

        Orders o = new Orders();
        o.setName(orders.getName());
        o.setAddress(orders.getAddress());
        o.setMobile(orders.getMobile());
        o.setPaymentMode(orders.getPaymentMode());
        List<UserCart> li=userCartService.getAllCart();
        double tt=0.0;
        for(UserCart u:li)
        {

            int pid=u.getProductId();
           double amount= userCartService.getPriceFromProductId(pid);
           tt+=amount*u.getProductQuantity();
        }
        o.setTotalAmount(tt);
        ordersRepository.save(o);
        userCartService.deleteAll();
        return tt;

}
    @Transactional
    public List<Orders> getAllOrders()
    {
        return ordersRepository.findAll();
    }

}
