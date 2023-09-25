package com.gainsight.onlineshopping.Controller;


import com.gainsight.onlineshopping.Service.UsersService;
import com.gainsight.onlineshopping.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Users")
@RestController
public class UsersController
{
     @Autowired
     UsersService usersService;
    @CrossOrigin
     @PostMapping(consumes="application/json")
     public int login(@RequestBody Users user)
     {

         String username=user.getUsername();
         String password=user.getPassword();
         if(usersService.authenticate(username,password))
             return 1;
         return 0;


     }
     @CrossOrigin
    @GetMapping(value="/show")
    public ResponseEntity<List<Users>> getAll()
     {
         return new ResponseEntity<List<Users>>(usersService.getAll(),HttpStatus.OK);
     }


}
