package com.example.myspringboot.contorller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myspringboot.entity.MyUser;

/**
 * 
 * @author wujw
 *
 */
@Controller
@RequestMapping("/myuser")
public class MyUserController {
	@RequestMapping("/list")
	public String listUser(Model model,HttpSession session){
		List<MyUser> list =new ArrayList();
		int i=1;
		while(i<=10){
			MyUser myuser =new MyUser();
			myuser.setAddress("广州"+i);
			myuser.setAge(String.valueOf(i));
			myuser.setId(i);
			myuser.setName("user"+i);
			list.add(myuser);
			i++;
		}
		model.addAttribute("users", list);
		model.addAttribute("user", "小明aa");
		session.setAttribute("sess", "sess");
		model.addAttribute("mydate", new Date());
		return "/myuser/list";
	}
}
