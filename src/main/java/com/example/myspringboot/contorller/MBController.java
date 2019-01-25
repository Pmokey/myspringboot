package com.example.myspringboot.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myspringboot.service.myuser.MBUserService;

@RestController
@RequestMapping("MB")
public class MBController {
	@Autowired
	MBUserService mbUserService;
	
	@RequestMapping("findAll")
	public Object findAll(){
		return mbUserService.findAll();
	}
}
