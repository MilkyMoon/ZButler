package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.ThinkUserDao;
import com.linestore.vo.ThinkUser;
@Transactional
public class ThinkUserDaoImpl extends HibernateDaoSupport implements ThinkUserDao{
	
	public List<ThinkUser> queryFormat(List<ThinkUser> list, int pid, int level) {
//		System.out.println(level);
		List<ThinkUser> catetories = (List<ThinkUser>) this.getHibernateTemplate().find("from ThinkUser where area.pid=?", pid);
		if (catetories != null) {
			for (int i = 0; i < catetories.size(); i++) {
				if (level != 0) {
					ThinkUser cate = new ThinkUser(catetories.get(i));
					String str = "";
					for (int j = 0; j < level; j++) {
						str += "|---";
					}
					cate.getArea().setArea(str + cate.getArea().getArea());
					System.out.println(cate.getArea().getArea());
					list.add(cate);
				} else {
					list.add(catetories.get(i));
				}
				queryFormat(list, catetories.get(i).getArea().getAreId(), level+1);
			}
		}
		return catetories;
	}

	@Override
	public void add(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(thinkUser);
	}

	@Override
	public void delete(int thuId) {
		// TODO Auto-generated method stub
		List<ThinkUser> thinkUsers = (List<ThinkUser>) this.getHibernateTemplate().find("from ThinkUser where thuId=?", thuId);
		this.getHibernateTemplate().delete(thinkUsers.get(0));
	}

	@Override
	public ThinkUser selectById(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		String hql = "from ThinkUser where thuId = ?";
		List<ThinkUser> list = (List<ThinkUser>) this.getHibernateTemplate().find(hql, thinkUser.getThuId());
		
		if(list!= null && list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public List<ThinkUser> select(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		String hql = "from ThinkUser where area.area like '%"+thinkUser.getThuName()+"%' or thuName like '%"+thinkUser.getThuName()+"%' or thuEmail like '%"+thinkUser.getThuName()+"%' or thuPhone like '%"+thinkUser.getThuName()+"%'";
		
		List<ThinkUser> list = (List<ThinkUser>) this.getHibernateTemplate().find(hql);
		
		if(list.size() > 0){
			return list;
		}
		
		return null;
	}

	@Override
	public void status(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(thinkUser);
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.clear();
	}

	@Override
	public ThinkUser checkThinkUser(ThinkUser thinkUser) {
		System.out.println("exec checkThinkuser");
		try {
			System.out.println("thinkuser: " + thinkUser.getThuUsername());
			System.out.println("thinkuser: " + thinkUser.getThuPassword());
			List<ThinkUser> thus = (List<ThinkUser>) this.getHibernateTemplate().findByExample(thinkUser);
			
			if (thus.size() < 1) {
				System.out.println("******");
				return null;
			} else {
				if (thus.get(0).getThuStatus() == 1) {
					System.out.println("---------");
					return thus.get(0);
					
				} else {
					System.out.println("@@@@@@@@@");
					return null;
				}
			}
		} catch (RuntimeException e) {
			System.out.println("check failed!\n" + e);
			throw e;
		}
	}
	
	public ThinkUser queryById(int thuId) {
		List<ThinkUser> thus = (List<ThinkUser>) this.getHibernateTemplate().find("from ThinkUser where thuId=?", thuId);
		if (thus.size() > 0) {
			return thus.get(0);
		}
		return null;
	}
}
