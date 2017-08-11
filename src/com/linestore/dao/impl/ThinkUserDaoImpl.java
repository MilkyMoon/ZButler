package com.linestore.dao.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.ThinkUserDao;
import com.linestore.util.Page;
import com.linestore.vo.Area;
import com.linestore.vo.ThinkUser;
@Transactional
public class ThinkUserDaoImpl extends HibernateDaoSupport implements ThinkUserDao{
	
	public List<ThinkUser> queryFormat(List<ThinkUser> list, int pid, int level) {
//		System.out.println(level);
		List<ThinkUser> thinkusers = (List<ThinkUser>) this.getHibernateTemplate().find("from ThinkUser where area.pid=?", pid);
		if (thinkusers != null) {
			for (int i = 0; i < thinkusers.size(); i++) {
				if (level != 0) {
					ThinkUser thinkuser = new ThinkUser(thinkusers.get(i));
					String str = "";
					for (int j = 0; j < level; j++) {
						str += "|---";
					}
					Area area = new Area(thinkusers.get(i).getArea());
					area.setArea(str + area.getArea());
					thinkuser.setArea(area);
					System.out.println(area.getArea());
					list.add(thinkuser);
				} else {
					list.add(thinkusers.get(i));
				}
				queryFormat(list, thinkusers.get(i).getArea().getAreId(), level+1);
			}
		}
		return thinkusers;
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
			List<ThinkUser> thus = (List<ThinkUser>) this.getHibernateTemplate().find("from ThinkUser where thuUsername='"+thinkUser.getThuUsername()+"' and thuPassword='"+thinkUser.getThuPassword()+"'");
			
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

	@Override
	public List<ThinkUser> selectAllByArea(Page page, Integer[] list) {
		// TODO Auto-generated method stub
		String hql = "from ThinkUser where area.areId in (:list)";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("list", Arrays.asList(list));
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}
	
	@Override
	public int selectAllByAreaCount(Integer[] list) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThinkUser where area.areId in (:list)";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setParameterList("list", Arrays.asList(list));
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

	@Override
	public List<ThinkUser> selectAllByKey(Page page, String keywords) {
		// TODO Auto-generated method stub
		String hql = "from ThinkUser where area.area like '%"+keywords+"%' or thuName like '%"+keywords+"%' or thuEmail like '%"+keywords+"%' or thuPhone like '%"+keywords+"%'";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public int selectAllByKeyCount(String keywords) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThinkUser where area.area like '%"+keywords+"%' or thuName like '%"+keywords+"%' or thuEmail like '%"+keywords+"%' or thuPhone like '%"+keywords+"%'";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}

	@Override
	public List<ThinkUser> selectAllByKey(String keywords) {
		// TODO Auto-generated method stub
		String hql = "from ThinkUser where area.area like '%"+keywords+"%' or thuName like '%"+keywords+"%' or thuEmail like '%"+keywords+"%' or thuPhone like '%"+keywords+"%'";
		List<ThinkUser> list = (List<ThinkUser>) this.getHibernateTemplate().find(hql);
		
		return list;
	}
}
