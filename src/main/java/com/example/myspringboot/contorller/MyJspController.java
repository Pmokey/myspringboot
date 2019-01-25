package com.example.myspringboot.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyJspController {
	@RequestMapping("myjsp")
	public String myjsp(Model model){
		model.addAttribute("a","测试的jsp");
		return "myJsp";
	}
}
