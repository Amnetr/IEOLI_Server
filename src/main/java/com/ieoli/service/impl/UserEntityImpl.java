package com.ieoli.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ieoli.Utils.EncoderPlus;
import com.ieoli.dao.UserEntityMapper;
import com.ieoli.entity.UserEntity;
import com.ieoli.entity.UserEntityExample;
import com.ieoli.service.UserService;
@Service("userservice")
public class UserEntityImpl implements UserService {
	
	@Resource
	private UserEntityMapper userMapper;

	@Override
	public UserEntity getUserByID(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Boolean login(UserEntity user) {
		UserEntityExample ueEntityExample = new UserEntityExample();
		ueEntityExample.createCriteria().andUsernameEqualTo(user.getUsername()).andUserpasswordEqualTo(EncoderPlus.getMD5(user.getUserpassword()));
		
		List<UserEntity> uList = userMapper.selectByExample(ueEntityExample);
		if(uList.isEmpty())
		{
			return false;
		}else {
			return true;
		}
		
		
		
	}

	@Override
	public UserEntity getUserByUsername(String username) {
		// TODO Auto-generated method stub
		UserEntityExample ueEntityExample = new UserEntityExample();
		ueEntityExample.createCriteria().andUsernameEqualTo(username);
		List<UserEntity> uList = userMapper.selectByExample(ueEntityExample);
		if(uList.isEmpty())
		{
			return null;
		}else {
			return uList.get(0);
		}
		
	}

	@Override
	public void Signup(UserEntity user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

}
