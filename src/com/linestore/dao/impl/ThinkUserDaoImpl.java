package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.ThinkUserDao;
import com.linestore.vo.ThinkUser;

public class ThinkUserDaoImpl extends HibernateDaoSupport implements ThinkUserDao{
	
	public List<ThinkUser> queryFormat(List<ThinkUser> list, int pid, int level) {
//		System.out.println(level);
		List<ThinkUser> catetories = (List<ThinkUser>) this.getHibernateTemplate().find("from ThinkUser where thuPid=?", pid);
		if (catetories != null) {
			for (int i = 0; i < catetories.size(); i++) {
				if (level != 0) {
					ThinkUser cate = new ThinkUser(catetories.get(i));
					String str = "";
					for (int j = 0; j < level; j++) {
						str += "|---";
					}
					cate.setThuArea(str + cate.getThuArea());
					list.add(cate);
				} else {
					list.add(catetories.get(i));
				}
				queryFormat(list, catetories.get(i).getThuId(), level+1);
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
	public void delete(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(thinkUser);
	}

	@Override
	public ThinkUser selectById(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		String hql = "from ThinkUser where thuId = ?";
		List<ThinkUser> list = (List<ThinkUser>) this.getHibernateTemplate().find(hql, thinkUser.getThuId());
		
		if(list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public List<ThinkUser> select(ThinkUser thinkUser) {
		// TODO Auto-generated method stub
		String hql = "from ThinkUser where thuArea like '%"+thinkUser.getThuName()+"%' or thuName like '%"+thinkUser.getThuName()+"%' or thuEmail like '%"+thinkUser.getThuName()+"%' or thuPhone like '%"+thinkUser.getThuName()+"%'";
		
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
}
