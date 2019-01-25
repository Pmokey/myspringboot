package com.example.myspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myspringboot.entity.MyUser;

public interface JpaMyUserDao extends JpaRepository<MyUser, Integer> {

}
