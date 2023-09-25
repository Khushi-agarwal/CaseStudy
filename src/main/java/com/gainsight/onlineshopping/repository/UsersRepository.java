package com.gainsight.onlineshopping.repository;


import com.gainsight.onlineshopping.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String>
{
    Optional<Users> findByUsernameAndPassword(String username,String password);
}
