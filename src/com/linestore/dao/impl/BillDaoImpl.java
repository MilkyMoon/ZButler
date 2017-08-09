package com.linestore.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.BillDao;
import com.linestore.util.Page;
import com.linestore.vo.Bill;

@Transactional
public class BillDaoImpl extends HibernateDaoSupport implements BillDao{

	@Override
	public List<Bill> select(Page page, Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Bill where areaByThuPropertyId.areId = ? or areaByThuCityId.areId = ? or areaByThuProvinceId.areId = ?";
		List<Bill> list = (List<Bill>) this.getHibernateTemplate().find(hql, id, id, id);
		return list;
	}

	@Override
	public List<Bill> selectAll(Page page) {
		// TODO Auto-generated method stub
//		String hql = "from Bill";
//		List<Bill> list = (List<Bill>) this.getHibernateTemplate().find(hql);
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Bill order by bilId desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

	@Override
	public List<Bill> search(String keywords) {
		// TODO Auto-generated method stub
		String hql = "from Bill where business.busShopName like '%"+keywords+"%' or customer.cusNickname like '%"+keywords+"%' or areaByThuPropertyId.area like '%"+keywords+"%' or areaByThuPropertyId.thuArea like '%"+keywords+"%' or areaByThuCountyId.area like '%"+keywords+"%' or areaByThuCountyId.thuArea like '%"+keywords+"%' or areaByThuCityId.area like '%"+keywords+"%' or areaByThuCityId.thuArea like '%"+keywords+"%' or areaByThuProvinceId.area like '%"+keywords+"%' or areaByThuProvinceId.thuArea like '%"+keywords+"%'";
		List<Bill> list = (List<Bill>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public int queryAll(String hql) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(hql);
		int count = Integer.parseInt(String.valueOf(query.uniqueResult()));
		
		return count;
	}
	
	public String  mkData(){
		
		StringBuffer sb = new StringBuffer("");
		Map<String,String> myMap= new HashMap<String,String>(40);
		myMap.put("吉林省","cn-jl");        
		myMap.put("天津市","cn-tj");        
		myMap.put("安徽省","cn-ah");        
		myMap.put("山东省","cn-sd");        
		myMap.put("山西省","cn-sx");        
		myMap.put("新疆维吾尔自治区","cn-xj");
		myMap.put("河北省","cn-hb");        
		myMap.put("河南省","cn-he");        
		myMap.put("湖南省","cn-hn");        
		myMap.put("甘肃省","cn-gs");        
		myMap.put("福建省","cn-fj");        
		myMap.put("贵州省","cn-gz");        
		myMap.put("重庆市","cn-cq");        
		myMap.put("江苏省","cn-js");        
		myMap.put("湖北省","cn-hu");        
		myMap.put("内蒙古自治区","cn-nm");  
		myMap.put("广西壮族自治区","cn-gx"); 
		myMap.put("黑龙江省","cn-hl");      
		myMap.put("云南省","cn-yn");        
		myMap.put("辽宁省","cn-ln");        
		myMap.put("香港特别行政区","cn-6668"); 
		myMap.put("浙江省","cn-zj");        
		myMap.put("上海市","cn-sh");        
		myMap.put("北京市","cn-bj");        
		myMap.put("广东省","cn-gd");        
		myMap.put("澳门特别行政区","cn-3681"); 
		myMap.put("西藏自治区","cn-xz");    
		myMap.put("陕西省","cn-sa");        
		myMap.put("四川省","cn-sc");        
		myMap.put("海南省","cn-ha");        
		myMap.put("宁夏回族自治区","cn-nx"); 
		myMap.put("青海省","cn-qh");        
		myMap.put("江西省","cn-jx");        
		myMap.put("台湾省","tw-tw");        
		
		//  {"hc-key": "cn-sh","value": 0},
		Random random = new Random();
		String value="";
		for (Object o : myMap.keySet()) { 
			value= random.nextInt(100)+1+"" ;
			sb.append("{'hc-key':'").
			append(myMap.get(o)).
			append("','value':").
			append(value).
			append("},").append("\n");
			;
        }
		
		return  sb.deleteCharAt(sb.length()-1)+"";
    }
    
	public void addBill(Bill bill) {
		this.getHibernateTemplate().save(bill);
	}

	@Override
	public Bill selectById(Integer id) {
		// TODO Auto-generated method stub
		List<Bill> btas = (List<Bill>) this.getHibernateTemplate().find("from Bill where bilId=" + id);
		return btas.get(0);
	}

	@Override
	public List<Bill> selectByTime(Page page, Integer id, String timeMin, String timeMax, Float amountMin,
			Float amountMax) {
		// TODO Auto-generated method stub
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Bill where (areaByThuPropertyId.areId = "+id+" or areaByThuCityId.areId = "+id+" or areaByThuProvinceId.areId = "+id+") and bilDate >= '"+timeMin+"' and bilDate <= '"+timeMax+"' and bilCusMoney >= "+amountMin+" and bilCusMoney <= "+amountMax+" order by bilId desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		
		return query.list();
	}

	@Override
	public List<Bill> selectAllByTime(Page page, String timeMin, String timeMax, Float amountMin, Float amountMax) {
		// TODO Auto-generated method stub
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query= session.createQuery("from Bill where bilDate >= '"+timeMin+"' and bilDate <= '"+timeMax+"' and bilCusMoney >= "+amountMin+" and bilCusMoney <= "+amountMax+" order by bilId desc");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		
		return query.list();
	}

}
