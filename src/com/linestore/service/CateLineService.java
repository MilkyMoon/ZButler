package com.linestore.service;

import java.util.List;

import com.linestore.vo.CateLine;

public interface CateLineService {
	public List<CateLine> selectAll();
	public void save(CateLine cateLine);
	public void delete(CateLine cateLine);
	public void status(CateLine cateLine);
	public CateLine selectById(CateLine cateLine);
	void update(String hql);
	
	public List<CateLine> selectEight(int pid);
	
	public CateLine queryByName(String seach);
	
	public List<CateLine> selectChildren(int pid);
	public List<CateLine> queryFormat(List<CateLine> list, int pid, int level);
}
