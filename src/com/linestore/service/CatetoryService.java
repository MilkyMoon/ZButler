package com.linestore.service;

import java.util.List;

import com.linestore.vo.Catetory;

public interface CatetoryService {
	
public void addCatetory(Catetory catetory);
	
	public void delCatetory(Catetory catetory);
	
	public void updateCatetoey(Catetory catetory);
	
	public List<Catetory> queryByPid(int pid);
	
	
	public List<Catetory> queryAll();


}
