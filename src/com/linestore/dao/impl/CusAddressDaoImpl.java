package com.linestore.dao.impl;

import com.linestore.dao.CusAddressDao;

import com.linestore.vo.CusAddressModel;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 收货地址管理的实现类
 * 
 * @author AmenWu
 *
 */
public class CusAddressDaoImpl extends HibernateDaoSupport implements CusAddressDao {
	public void add(CusAddressModel cusAddress) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法！");
		// 执行插入方法
		// this.getHibernateTemplate().save(busAddress);
		System.out.println(this.getHibernateTemplate().save(cusAddress));
	}

	@Override
	public List<CusAddressModel> selectAll(CusAddressModel cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from CusAddressModel where customer.cusId = ?";
		List<CusAddressModel> list = (List<CusAddressModel>) this.getHibernateTemplate().find(hql,cusAddress.getCustomer().getCusId());
		
		return list;
	}

	@Override
	public CusAddressModel select(CusAddressModel cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		CusAddressModel cusAddressResult=null;
		String hql = "from CusAddressModel where caId = ?";
		List<CusAddressModel> list = (List<CusAddressModel>) this.getHibernateTemplate().find(hql,
				cusAddress.getCaId());
		if (list.size() > 0) {
			cusAddress = list.get(0);
		}
		return cusAddress;
	}
	@Override
	public void update(CusAddressModel cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		this.getHibernateTemplate().update(cusAddress);;

	}

	@Override
	public void del(CusAddressModel cusAddress) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
				this.getHibernateTemplate().delete(cusAddress);
		
	}
}
