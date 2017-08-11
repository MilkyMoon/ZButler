package com.linestore.service;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.ThuTrading;

public interface ThuTradingService {
	public int selectCount();
	public List<ThuTrading> select(Page page);
	public void save(ThuTrading thuTrading);
	public void update(String hql);
	public int selectByKeyCount(Integer[] thuList,Integer[] areList);
	public int selectByKeyCountToThu(Integer[] thuList);
	public int selectByKeyCountToAre(Integer[] areList);
	public List<ThuTrading> selectByKey(Page page,Integer[] thuList,Integer[] areList);
	public List<ThuTrading> selectByKeytoThu(Page page,Integer[] thuList);
	public List<ThuTrading> selectByKeytoAre(Page page,Integer[] areList);
	public ThuTrading selectById(String id);
	public void update(ThuTrading thuTrading);
	public ThuTrading selectByAreaId(int id);
}
