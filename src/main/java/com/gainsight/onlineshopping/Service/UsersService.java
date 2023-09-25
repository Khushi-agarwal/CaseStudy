package com.gainsight.onlineshopping.Service;


import com.gainsight.onlineshopping.entity.Users;
import com.gainsight.onlineshopping.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService
{
	@Autowired
	UsersRepository usersRepository;



	@Transactional
	public boolean addUsers(Users user)
	{

		user.setPassword(user.getPassword());
		Users u = usersRepository.save(user);
		return u!=null;
	}
	@Transactional
	public boolean authenticate(String username,String password)
	{
            Optional<Users> u=usersRepository.findById(username);
			boolean value=false;
			if(u.isPresent())
			{

				if(Objects.equals(u.get().getPassword(), password))
					value= true;
			}

			return value;
	}
	@Transactional(readOnly = true)
	public List<Users> getAll()
	{
		return usersRepository.findAll();
	}

}
