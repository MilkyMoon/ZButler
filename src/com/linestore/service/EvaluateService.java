package com.linestore.service;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Evaluate;

public interface EvaluateService {

	public void addEvaluate(Evaluate evaluate);

	public void delEvaluate(int evaId);
	
	public int allLength();

	public List<Evaluate> queryAll();

	public List<Evaluate> queryAll(Page page);

}
