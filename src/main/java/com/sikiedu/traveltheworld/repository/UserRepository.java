package com.sikiedu.traveltheworld.repository;

import org.springframework.data.repository.CrudRepository;

import com.sikiedu.traveltheworld.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsernameAndPassword(String username,String password);			
}
