package com.linestore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.linestore.dao.AreaDao;
import com.linestore.vo.Area;
import com.linestore.vo.CateLine;

public class AreaDaoImpl extends HibernateDaoSupport implements AreaDao {

	@Override
	public void addArea(Area area) {
		System.out.println("ecex addArea");
		try {
			this.getHibernateTemplate().save(area);
			System.out.println("addArea successful");
		} catch (RuntimeException e) {
			System.out.println("addArea failed!");
			throw e;
		}
	}

	@Override
	public void delArea(int areaId) {
		System.out.println("ecex delArea");
		try {
			Area area = this.getHibernateTemplate().load(Area.class, areaId);
			this.getHibernateTemplate().delete(area);
			System.out.println("delArea successful");
		} catch (RuntimeException e) {
			System.out.println("delArea failed!");
			throw e;
		}
	}

	@Override
	public void updateArea(Area area) {
		System.out.println("ecex updateArea");
		try {
			this.getHibernateTemplate().update(area);
			System.out.println("updateArea successful");
		} catch (RuntimeException e) {
			System.out.println("updateArea failed!");
			throw e;
		}
	}

	@Override
	public void upadteArea(String hql) {
		System.out.println("exec upadteArea");
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("upadteArea successful!");
		} catch (RuntimeException e) {
			System.out.println("upadteArea failed!");
			throw e;
		}
		
	}

	@Override
	public List<Area> queryArea(List<Area> list, int pid, int level) {
		List<Area> areas = (List<Area>) this.getHibernateTemplate().find("from Area where pid=?", pid);
		if (areas != null) {
			for (int i = 0; i < areas.size(); i++) {
				if (level != 0) {
					Area area = new Area(areas.get(i));
					String str = "";
					for (int j = 0; j < level; j++) {
						str += "|---";
					}
					area.setArea(str + area.getArea());
					list.add(area);
				} else {
					list.add(areas.get(i));
				}
				queryArea(list, areas.get(i).getId(), level+1);
			}
		}
		return areas;
	}

	@Override
	public List<Area> queryByPid(int pid) {
		System.out.println("exec queryByPid");
		try {
			List<Area> areas = (List<Area>) this.getHibernateTemplate().find("from Area where pid=?", pid);
			System.out.println("queryByPid successful!");
			return areas;
		} catch (RuntimeException e) {
			System.out.println("queryByPid failed!");
			throw e;
		}
	}

	@Override
	public Area queryById(int id) {
		System.out.println("exec queryById");
		try {
			List<Area> areas = (List<Area>) this.getHibernateTemplate().find("from Area where id=?", id);
			System.out.println("queryById successful!");
			if (areas.size() > 0) {
				return areas.get(0);
			}
			return null;
		} catch (RuntimeException e) {
			System.out.println("queryById failed!");
			throw e;
		}
	}
	
	
	
}
