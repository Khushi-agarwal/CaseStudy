package com.gainsight.onlineshopping.repository;

import com.gainsight.onlineshopping.entity.UserCart;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCartRepository extends JpaRepository<UserCart,Integer> {
}
