package com.linestore.dao.impl;

import com.linestore.dao.CusAddressDao;
import com.linestore.dao.MessageDao;
import com.linestore.vo.CusAddress;
import com.linestore.vo.Message;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 收货地址管理的实现类
 * 
 * @author AmenWu
 *
 */
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

	@Override
	public List<Message> selectAll(Message message) {
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from Message where customer.cusId = ?";
		List<Message> list = (List<Message>) this.getHibernateTemplate().find(hql,
				message.getCustomer().getCusId());

		return list;
	}

	@Override
	public void add(Message message) {
		System.out.println("DAO中的save方法！");
		// 执行插入方法
		System.out.println(this.getHibernateTemplate().save(message));

	}

}
