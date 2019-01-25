package com.example.myspringboot.service.myuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringboot.dao.MyUserDao;
import com.example.myspringboot.entity.MyUser;

@Service
public class MBUserService {
	@Autowired
	MyUserDao userDao;
	
	public List<MyUser> findAll(){
		return userDao.findAll();
	}
}
