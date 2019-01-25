package com.example.myspringboot.service.myuser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.myspringboot.dao.MyUserDao;
import com.example.myspringboot.entity.MyUser;

@Service
public class MyUserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void add(MyUser myuser){
		jdbcTemplate.update("insert into myuser(name,age,address) values(?,?,?)",myuser.getName(),myuser.getAge(),myuser.getAddress());
	}
	
	public void delete(Integer id){
		jdbcTemplate.update("delete from myuser where id=?", id);
	}
	
	public List<MyUser> findAll(){
		List<MyUser> query = jdbcTemplate.query("select * from myuser",new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				MyUser user =new MyUser();
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getString("age"));
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}});
		return query;
	}
	
	public void update(MyUser user){
		jdbcTemplate.update("update myuser set name=?,address=?,age=? where id=?",user.getName(),user.getAddress(),user.getAge(),user.getId());
	}
	
	public Map<String,Object> findById(Integer id){
		Map<String, Object> queryForMap = jdbcTemplate.queryForMap("select * from myuser where id=?", id);
		return queryForMap;
	}
}
