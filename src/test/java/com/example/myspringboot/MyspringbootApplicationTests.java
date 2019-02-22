package com.example.myspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringbootApplicationTests {
    
	@Test
	public void contextLoads() {
	}
	private static final Logger logger = (Logger) LoggerFactory.getLogger(MyspringbootApplicationTests.class);
	@Test
	public void testLog(){
	    logger.info("日志测试开始");
	    int i=0 ;
	    while(i<100*1000){
	        logger.debug("这个是中文");
	        logger.debug(MyspringbootApplicationTests.class.getName());
	        
	        logger.info("这个是中文");
            logger.info(MyspringbootApplicationTests.class.getName());
            
            logger.warn("这个是中文");
            logger.warn(MyspringbootApplicationTests.class.getName());
            
            logger.error("这个是中文");
            logger.error(MyspringbootApplicationTests.class.getName());
	        
	        i++;
	    }
	}

}

