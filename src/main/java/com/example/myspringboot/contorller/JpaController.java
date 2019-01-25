package com.example.myspringboot.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myspringboot.dao.JpaMyUserDao;

@Controller
@RequestMapping("/jpa")
public class JpaController {
	@Autowired
	JpaMyUserDao jpaUserDao;
	
	@ResponseBody
	@RequestMapping("/findAll")
	public Object findAll(){
		return jpaUserDao.findAll();
	}
}
