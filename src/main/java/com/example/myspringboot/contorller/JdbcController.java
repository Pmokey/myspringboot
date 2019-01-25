package com.example.myspringboot.contorller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myspringboot.entity.MyUser;
import com.example.myspringboot.service.myuser.MyUserService;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {
	@Autowired
	private MyUserService myUserService;
	
	@RequestMapping("/viewadd")
	public String viewAdd(@ModelAttribute("Valid") MyUser user){
		return "/jdbc/add";
	}
	
	@RequestMapping("/add")
	public String addUser(Model model,@ModelAttribute("Valid") @Valid MyUser users,BindingResult result) throws IOException{
//		public void addUser(Model model,HttpServletResponse response, @RequestParam(value="name",required = false) String name	
//				,@RequestParam(value="age",required = false) String age
//				,@RequestParam(value="address",required = false) String address) throws IOException{
		if(result.hasErrors()){
			return "/jdbc/add";
		}else{
			myUserService.add(users);
			model.addAttribute("msg", "成功");
			return "ok";
		}
//		
//		if(StringUtils.isEmpty(name)){
//			model.addAttribute("msg", "");
//		}else{
//			MyUser user =new MyUser();
//			user.setAddress(address);
//			user.setAge(age);
//			user.setName(name);
//			System.out.println(user.toString());
//			myUserService.add(user);
//			model.addAttribute("msg", "添加成功");
//		}
		
	}
	@RequestMapping("/list")
	public String listAll(Model model){
		List<MyUser> userList = myUserService.findAll();
		model.addAttribute("users", userList);
		return "/jdbc/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, @RequestParam(value="id",required = false) Integer id){
		if(StringUtils.isEmpty(id)){
			model.addAttribute("msg", "id不能为空");
		}else{
			myUserService.delete(id);
			model.addAttribute("msg", id+"删除成功");
		}
		List<MyUser> userList = myUserService.findAll();
		model.addAttribute("users", userList);
		return "/jdbc/list";
	}
	
	@RequestMapping("/viewupdate")
	public String viewupdate(Model model, @RequestParam(value="id",required = false) Integer id){
		if(StringUtils.isEmpty(id)){
			model.addAttribute("msg", "id不能为空");
		}else{
			Map<String, Object> findById = myUserService.findById(id);
			model.addAttribute("user",findById);
		}
		return "/jdbc/update";
	}
	
	@PostMapping("update")
	public String update(Model model, @RequestParam(value="name",required = false) String name	
			,@RequestParam(value="age",required = false) String age,@RequestParam(value="id",required = false) Integer id
			,@RequestParam(value="address",required = false) String address){
		if(StringUtils.isEmpty(id)){
			model.addAttribute("msg", "id不能为空");
		}else{
			MyUser user =new MyUser();
			user.setAddress(address);
			user.setAge(age);
			user.setId(id);
			user.setName(name);
			myUserService.update(user);
			model.addAttribute("msg", id+"更新成功");
		}
		List<MyUser> userList = myUserService.findAll();
		model.addAttribute("users", userList);
		return "/jdbc/list";
	}
}
