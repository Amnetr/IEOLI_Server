package com.ieoli.Controller;

import javax.annotation.Resource;

import com.ieoli.entity.UserEntity;
import com.ieoli.service.UserService;

public class UserBehavior {

	@Resource
	private UserService us;
	public void update(UserEntity user){
		us.updateUser(user);
	}
	public UserEntity getByID(int id){
		return us.getUserByID(id);
	}
}
