package com.linestore.dao.impl;

import com.linestore.dao.CusAddressDao;
import com.linestore.dao.MessageDao;
import com.linestore.util.Page;
import com.linestore.vo.CusAddress;
import com.linestore.vo.Customer;
import com.linestore.vo.Message;
import com.linestore.vo.Notice;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
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
		List<Message> list = (List<Message>) this.getHibernateTemplate().find(hql, message.getCustomer().getCusId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		for (Message mes : list) {
			mes.setMesTimeStr(sdf.format(mes.getMesTime().getTime()));
		}

		return list;
	}

	@Override
	public void add(Message message) {
		System.out.println("DAO中的save方法！");
		// 执行插入方法
		System.out.println(this.getHibernateTemplate().save(message));

	}

	@Override
	public void del(Message message) {
		System.out.println("DAO中的del方法！");
		// 执行插入方法
		this.getHibernateTemplate().delete(message);

	}

	@Override
	public List<Message> SelectAll(Page page) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Message order by mesTime desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());

		return query.list();
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		String hql = "from Message where mesId = ?";
		List<Message> list = (List<Message>) this.getHibernateTemplate().find(hql, id);
		this.getHibernateTemplate().delete(list.get(0));
	}

	@Override
	public int queryAll() {
		System.out.println("exec queryAll");
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("select count(*) from Message");
			int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
			System.out.println(count);

			System.out.println("query successful");
			return count;
		} catch (RuntimeException e) {
			System.out.println("query failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<Message> search(int type) {
		// TODO Auto-generated method stub
		String hql;
		hql = "from Message where mesType =" + type;

		List<Message> list = (List<Message>) this.getHibernateTemplate().find(hql);
		return list;
	}

}
