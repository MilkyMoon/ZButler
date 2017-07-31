package com.linestore.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport{
	private File file; //file控件名
    private String fileContentType;//图片类型
    private String fileFileName; //文件名
    private Integer number;

	public String saveImg(){
		System.out.println("图片上传！");
        HttpServletRequest request = ServletActionContext.getRequest();
        String root = request.getRealPath("/upload");//图片要上传到的服务器路径
        String names[]=fileFileName.split("\\.");
        String fileName="";
        if(names.length>=1){
            fileName=getRandomString(20)+"."+names[names.length-1];
        }
        String picPath="upload/"+fileName;//图片保存到数据库的路径
        System.out.println("pinPath:"+picPath);
        File file1=new File(root);
        try {
        	FileUtils.copyFile(file, new File(file1,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
    
    /*获取一条随机字符串*/
    public String getRandomString(int length) { //length表示生成字符串的长度  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     } 

	

}
