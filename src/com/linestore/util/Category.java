package com.linestore.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
	private String model;                                                          //分类的数据表模型
    private List<Map> rawList = new ArrayList<Map>();                        //原始的分类数据
    private List<Map> formatList = new ArrayList<Map>();                     //格式化后的分类
    private String error = "";                                                     //错误信息
    private String icon = "|---";  											//格式化的字符
    private Map fields = new HashMap();                         //字段映射，分类id，上级分类fid,分类名称name,格式化后分类名称fullname
    
	private List<Map> list = new ArrayList<Map>();
	
	public String[] getChild(int fid){
		String[] childs = null;
		for (Map<String, Object> m : rawList) {
			System.out.println("pid:" + (Integer)m.get(fields.get("pid")));
			if((Integer)m.get(fields.get("pid")) == fid){
				
			}
//			for (String k : m.keySet()) {  
//				System.out.println(k + " : " + m.get(k));  
//			}  
	  
	    }
//		for(int i = 0; i < rawList.size(); i++){
//			if(rawList.get(i).get(fields.get("pid")) == fid){
//				
//			}
//		}
		
		
		return childs;
	}
	
	public void searchList(int cid){
		String[] childs = getChild(cid);
		int m = childs.length;
		if (m == 0){
			return;
		}
		System.out.println("m长度：" + m);
		
	}
	
	public List<Map> getList(List<Map> category,String id_name,String pid_name,int start_id){
		this.rawList = category;
		this.fields.put("id", id_name);
		this.fields.put("pid", pid_name);
		this.fields.put("start_id", start_id);
		
		return list;
	}
}
