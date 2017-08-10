package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.CateLineDao;
import com.linestore.vo.CateLine;

public class CateLineDaoImpl extends HibernateDaoSupport implements CateLineDao{

	@Override
	public List<CateLine> selectAll() {
		List<CateLine> catetories = (List<CateLine>) this.getHibernateTemplate().find("from CateLine");
		return catetories;
	}

	@Override
	public void save(CateLine cateLine) {
		this.getHibernateTemplate().save(cateLine);
	}

	@Override
	public void delete(CateLine cateLine) {
		this.getHibernateTemplate().delete(cateLine);
	}

	@Override
	public void status(CateLine cateLine) {
		this.getHibernateTemplate().update(cateLine);
	}

	@Override
	public void update(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public CateLine selectById(CateLine cateLine) {
		// TODO Auto-generated method stub
		String hql = "from CateLine where calId = ?";
		List<CateLine> list = (List<CateLine>)this.getHibernateTemplate().find(hql, cateLine.getCalId());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public List<CateLine> selectEight(int pid) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from CateLine where calStatus=1 and calPid=" + pid+ " order by calAuth desc");
		query.setMaxResults(8);
		return query.list();
	}

	@Override
	public CateLine queryByName(String seach) {
		List<CateLine> cate = (List<CateLine>) this.getHibernateTemplate().find("from CateLine where calName='"+seach+"' and calStatus=1");
		if (cate.size() > 0) {
			return cate.get(0);
		}
		return null;
	}
	
	public List<CateLine> selectChildren(int pid) {
		return (List<CateLine>) this.getHibernateTemplate().find("from CateLine where calPid=? and calStatus=1", pid);
	}
	
	public List<CateLine> queryFormat(List<CateLine> list, int pid, int level) {
//		System.out.println(level);
		List<CateLine> catetories = (List<CateLine>) this.getHibernateTemplate().find("from CateLine where calPid=?", pid);
		if (catetories != null) {
			for (int i = 0; i < catetories.size(); i++) {
				if (level != 0) {
					CateLine cate = new CateLine(catetories.get(i));
					String str = "";
					for (int j = 0; j < level; j++) {
						str += "|---";
					}
					cate.setCalName(str + cate.getCalName());
					list.add(cate);
				} else {
					list.add(catetories.get(i));
				}
				queryFormat(list, catetories.get(i).getCalId(), level+1);
			}
		}
		return catetories;
	}
}
