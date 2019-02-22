package com.example.myspringboot.service.myuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.myspringboot.dao.MyUserDao;
import com.example.myspringboot.entity.MyUser;
import com.example.myspringboot.utils.PageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@CacheConfig(cacheNames="myCache")
public class MbUserService {
	@Autowired
	MyUserDao userDao;
	
	@Cacheable(key="'findAll'")
	public List<MyUser> findAll(){
		return userDao.findAll();
	}
	
	public Page<MyUser> findUserByPage(PageBean page){
	    PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
	    Page<MyUser> findUserByPage = userDao.findUserByPage((MyUser)page.getItems());
	    page.setItems(findUserByPage.getResult());
	    return findUserByPage;
	}
	
	public Page<MyUser> findUserByPage2(PageBean page){
	    PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
	    
	    return userDao.findUserByPage2((MyUser)page.getParm());
	}
}
