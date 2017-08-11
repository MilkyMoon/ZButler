package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.PicturesDao;
import com.linestore.service.PicturesService;
import com.linestore.vo.Pictures;

@Transactional
public class PicturesServiceImpl implements PicturesService {
	
	private PicturesDao picturesDao;

	@Override
	public void addPicture(Pictures pic) {
		picturesDao.addPicture(pic);
	}

	@Override
	public void updatePicture(String hql) {
		picturesDao.updatePicture(hql);
	}

	@Override
	public void delPicture(int id) {
		picturesDao.delPicture(id);
	}

	@Override
	public List<Pictures> queryByOtherId(int id) {
		return picturesDao.queryByOtherId(id);
	}

	public PicturesDao getPicturesDao() {
		return picturesDao;
	}

	public void setPicturesDao(PicturesDao picturesDao) {
		this.picturesDao = picturesDao;
	}

}
