package com.linestore.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.ThinkUserDao;
import com.linestore.vo.ThinkUser;

public class ThinkUserDaoImpl extends HibernateDaoSupport implements ThinkUserDao{
	
	public List<ThinkUser> queryFormat(List<ThinkUser> list, int pid, int level) {
		System.out.println(level);
		List<ThinkUser> catetories = (List<ThinkUser>) this.getHibernateTemplate().find("from ThinkUser where thuPid=?", pid);
		if (catetories != null) {
			for (int i = 0; i < catetories.size(); i++) {
				if (level != 0) {
					ThinkUser cate = new ThinkUser(catetories.get(i));
					String str = "";
					for (int j = 0; j < level; j++) {
						str += "|--";
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
}
