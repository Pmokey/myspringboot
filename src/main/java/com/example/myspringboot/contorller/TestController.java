package com.example.myspringboot.contorller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groovy.util.logging.Slf4j;


@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
	@Value(value = "${mysys.isweb}")
	String isweb;
	@RequestMapping("/t1")
	public Object test(){
		return isweb;
	}
	
	@DeleteMapping(value="/dog/{id}")
	public Object del(@PathVariable(required=true,name="id") String id){
		return "操作了delete，id="+id;
	}
	
	@GetMapping(value="/dog/{id}")
	public Object get(@PathVariable(required=true,name="id") String id){
		return "操作了get，id="+id;
	}
	
	@PostMapping(value="/dog")
	public Object post(@RequestBody JSONObject jsonObject){
		return "操作了post"+jsonObject;
	}
	
	@PutMapping(value="/dog")
	public Object put(@RequestBody JSONObject jsonObject){
		return "操作了put"+jsonObject;
	}
	
	@RequestMapping("test1")
	public Object test1(){
	    return "ok";
	}
}
