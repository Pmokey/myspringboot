package com.example.myspringboot.contorller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class UploadController {
	@PostMapping("/upload")
	public String uploadByPost(Model model,
	        @RequestParam("file") MultipartFile file){
		String msg= "";
	    if (!file.isEmpty()) {
	        try{
	            String filePath="C:/software/upload/"+file.getOriginalFilename();
	            BufferedOutputStream out=new BufferedOutputStream(
	                    new FileOutputStream(new File(filePath)));
	            out.write(file.getBytes());
	            out.flush();
	            out.close();
	            msg ="上传文件成功";
	        }
	        catch(Exception e){
	            e.printStackTrace();
	            msg ="上传文件失败："+e.getMessage();
	        }
	    }
	    else{
	    	 msg = "上传文件失败：文件为空";
	    }
	    System.out.print(msg);
	    return msg;
	}

}
