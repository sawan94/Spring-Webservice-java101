package com.sawan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sawan.model.User;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	private Map<Integer,User> users = new HashMap<>();

	@Override
	public Map<Integer,User> listAllUsers() {
		return users;
	}

	@Override
	public void addUser(User u) {
		u.setId(users.size());
		users.put(users.size(), u);
	}

	@Override
	public boolean deleteById(int id) {
		if(users.containsKey(id)){
			users.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		if(users.containsKey(user.getId())){
			users.remove(user.getId());
			users.put(user.getId(),user);
			return true;
		}
		return false;
	}


}
