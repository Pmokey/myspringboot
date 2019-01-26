package com.example.myspringboot.service.myuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.myspringboot.dao.MyUserDao;
import com.example.myspringboot.entity.MyUser;

@Service
@CacheConfig(cacheNames="myCache")
public class MBUserService {
	@Autowired
	MyUserDao userDao;
	
	@Cacheable(key="'findAll'")
	public List<MyUser> findAll(){
		return userDao.findAll();
	}
}
