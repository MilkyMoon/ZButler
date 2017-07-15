package com.linestore.dao.impl;

import com.linestore.dao.CusAddressDao;

import com.linestore.vo.CusAddress;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 收货地址管理的实现类
 * 
 * @author AmenWu
 *
 */
public class CusAddressDaoImpl extends HibernateDaoSupport implements CusAddressDao {
	public void add(CusAddress cusAddress) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法！");
		// 执行插入方法
		// this.getHibernateTemplate().save(busAddress);
		System.out.println(this.getHibernateTemplate().save(cusAddress));
	}

	@Override
	public List<CusAddress> selectAll(CusAddress cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from CusAddress where customer.cusId = ?";
		List<CusAddress> list = (List<CusAddress>) this.getHibernateTemplate().find(hql,cusAddress.getCustomer().getCusId());
		
		return list;
	}

	@Override
	public CusAddress select(CusAddress cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		CusAddress cusAddressResult=null;
		String hql = "from CusAddress where caId = ?";
		List<CusAddress> list = (List<CusAddress>) this.getHibernateTemplate().find(hql,
				cusAddress.getCaId());
		if (list.size() > 0) {
			cusAddress = list.get(0);
		}
		return cusAddress;
	}
	@Override
	public void update(CusAddress cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		this.getHibernateTemplate().update(cusAddress);;

	}

	@Override
	public void del(CusAddress cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
				this.getHibernateTemplate().delete(cusAddress);
		
	}
}
