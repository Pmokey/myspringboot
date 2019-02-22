package com.example.myspringboot.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myspringboot.entity.MyUser;
import com.example.myspringboot.service.myuser.MbUserService;
import com.example.myspringboot.utils.PageBean;
import com.github.pagehelper.Page;

/**
 * 
 * @author wujw
 *
 */
@RestController
@RequestMapping("MB")
public class MbController {
    
	@Autowired
	MbUserService mbUserService;
	
	@RequestMapping("findAll")
	public Object findAll(){
		return mbUserService.findAll();
	}
	
	@CacheEvict(value = "myCache",key="'findAll'")
	@RequestMapping("cleanCache")
	public Object cleanCache(){
		return "缓存清除成功";
	}
	@RequestMapping("fingUserByPage")
	public Object fingUserByPage(@RequestParam("pn") int pn,@RequestParam("ps") int ps){
	    PageBean pageBean=new PageBean();
	    pageBean.setCurrentPage(pn);
	    pageBean.setPageSize(ps);
	    MyUser myUser = new MyUser();
	    pageBean.setParm(myUser);
	    Page<MyUser> findUserByPage = mbUserService.findUserByPage(pageBean);
	    System.out.println(findUserByPage.toString());
	    return findUserByPage;
	}
	@RequestMapping("fingUserByPage2")
    public Object fingUserByPage2(@RequestParam("pn") int pn,@RequestParam("ps") int ps){
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(pn);
        pageBean.setPageSize(ps);
        MyUser myUser = new MyUser();
        pageBean.setParm(myUser);
        Page<MyUser> findUserByPage = mbUserService.findUserByPage2(pageBean);
        System.out.println("2"+findUserByPage.toString());
        return findUserByPage;
    }
}
