package com.linestore.dao;

import java.util.List;
import java.util.Map;

import com.linestore.vo.Catetory;

public interface CatetoryDao {
	
	public void addCatetory(Catetory catetory);
	
	public void delCatetory(Catetory catetory);
	
	public void updateCatetoey(Catetory catetory);
	
	public List<Catetory> queryByPid(int pid);
	
	
	public List<Catetory> queryAll();

	public List<Catetory> queryFormat(List<Catetory> list, int pid, int level);

}
