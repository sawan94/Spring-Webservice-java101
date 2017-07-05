package com.sawan.service;

import java.util.Map;

import com.sawan.model.User;

public interface CommonService {
	Map<Integer,User> listAllUsers();
	void addUser(User u);
	boolean deleteById(int id);
	boolean update(User user);	
}
