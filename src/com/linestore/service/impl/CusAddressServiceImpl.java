package com.linestore.service.impl;

import com.linestore.dao.CusAddressDao;
import com.linestore.service.CusAddressService;
import com.linestore.vo.CusAddressModel;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CusAddressServiceImpl implements CusAddressService{
		//业务层注入DAO的类
		private CusAddressDao cusAddressDao;

	

		public CusAddressDao getCusAddressDao() {
			return cusAddressDao;
		}

		public void setCusAddressDao(CusAddressDao cusAddressDao) {
			this.cusAddressDao = cusAddressDao;
		}

		@Override
		public void add(CusAddressModel cusAddress) {
			// TODO Auto-generated method stub
			System.out.println("Service中的save方法！");
			cusAddressDao.add(cusAddress);
		}

		@Override
		/**
		 * 业务层获取单个收货地址方法
		 */
		public List<CusAddressModel> selectAll(CusAddressModel cusAddress) {
			// TODO Auto-generated method stub
			
			List<CusAddressModel> busAddressList = cusAddressDao.selectAll(cusAddress);
			return busAddressList;
		}

		@Override
		public CusAddressModel select(CusAddressModel cusAddress) {
			// TODO Auto-generated method stub
			return cusAddressDao.select(cusAddress);
		}

		@Override
		public void update(CusAddressModel cusAddress) {
			cusAddressDao.update(cusAddress);
			
		}

		@Override
		public void del(CusAddressModel cusAddress) {
			cusAddressDao.del(cusAddress);
			
		}
}
