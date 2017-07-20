package com.linestore.dao;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Evaluate;

public interface EvaluateDao {
	
	public void addEvaluate(Evaluate evaluate);
	
	public void delEvaluate(int evaId);
	
	public List<Evaluate> queryAll();
	
	public List<Evaluate> queryAll(int cusId);
	
	public List<Evaluate> queryAll(Page page);

}
