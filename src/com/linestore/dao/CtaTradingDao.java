package com.linestore.dao;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.CtaTrading;

public interface CtaTradingDao {
	
	public void addCtaTrading(CtaTrading ctaTrading);
	
	public List<CtaTrading> queryByCusid(int cusId);
	
	public List<CtaTrading> queryPoint(int cusId);
	
	public CtaTrading queryById(String btaId);
	
	public List<CtaTrading> selectAll(Page page);
	
	public int queryAll();
	
	public void update(String hql);
	
	public List<CtaTrading> search(String keywords,int type);

	int queryAllType(int type);

	List<CtaTrading> selectAllType(Page page, int type);
	
}
