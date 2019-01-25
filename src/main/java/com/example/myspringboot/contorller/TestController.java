package com.example.myspringboot.contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@Value(value = "${mysys.isweb}")
	String isweb;
	@RequestMapping("/t1")
	public Object test(){
		return isweb;
	}
}
