package com.example.myspringboot.dao;

import java.util.List;

import com.example.myspringboot.entity.MyUser;

public interface MyUserDao {
	List<MyUser> findAll();
}
