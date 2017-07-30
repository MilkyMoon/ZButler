package com.linestore.service;

import java.util.List;

import com.linestore.vo.CtaTrading;

public interface CtaTradingService {
	
	public void addCtaTrading(CtaTrading ctaTrading);
	
	public List<CtaTrading> queryByCusid(int cusId);
	
	public List<CtaTrading> queryPoint(int cusId);
}
