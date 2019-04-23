package com.namanraj.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.namanraj.demo.model.User;


public interface LoginRepo extends CrudRepository<User , Integer> {

	public User findByUsernameAndPassword(String username , String password); 
}
