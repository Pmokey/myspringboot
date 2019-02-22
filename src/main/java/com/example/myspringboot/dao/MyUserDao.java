package com.example.myspringboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.myspringboot.entity.MyUser;
import com.github.pagehelper.Page;
/**
 * 
 * @author wujw
 *
 */
public interface MyUserDao {
	/**
	 * 查询所有内容
	 * @return
	 */
	List<MyUser> findAll();
	
	Page<MyUser> findUserByPage(MyUser user);
	
	@Select("select * from myuser")
	Page<MyUser> findUserByPage2(MyUser user);
}
