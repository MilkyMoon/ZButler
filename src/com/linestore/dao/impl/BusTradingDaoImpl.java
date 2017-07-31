package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.BusTradingDao;
import com.linestore.vo.BusTrading;

public class BusTradingDaoImpl extends HibernateDaoSupport implements BusTradingDao {

	@Override
	public List<BusTrading> queryHot() {
		List<BusTrading> btrs = (List<BusTrading>) this.getHibernateTemplate().find("from BusTrading group by business.busId ");
		return btrs;
	}

}
