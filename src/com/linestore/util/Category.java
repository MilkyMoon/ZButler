package com.linestore.util;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String model;                                                          //分类的数据表模型
    private List<String> rawList = new ArrayList<String>();                        //原始的分类数据
    private List<String> formatList = new ArrayList<String>();                     //格式化后的分类
    private String error = "";                                                     //错误信息
    private String icon = "|---";  											//格式化的字符
    private List<String> fields = new ArrayList<String>();                         //字段映射，分类id，上级分类fid,分类名称name,格式化后分类名称fullname
    
	private List<String> list = new ArrayList<String>();
	
	public String[] getChild(int id){
		String[] childs = null;
		
		return childs;
	}
	
	public List<String> searchList(){
		
		
		return list;
	}
}
