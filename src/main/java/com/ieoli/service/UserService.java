package com.ieoli.service;

import com.ieoli.entity.UserEntity;

public interface UserService {

	public UserEntity getUserByID(int id);
	public void updateUser(UserEntity user);
	public Boolean login(UserEntity user);
	public UserEntity getUserByUsername(String username);
	public void Signup(UserEntity user);
}
