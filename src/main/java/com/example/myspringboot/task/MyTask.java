package com.example.myspringboot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
	private static SimpleDateFormat sdf=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
//	@Scheduled(cron="*/1 * * * * ?")
	public void job(){
		System.out.println("定时任务，当前时间："+sdf.format(new Date()));
	}
}
