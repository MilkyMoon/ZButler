package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.TagDao;
import com.linestore.service.TagService;
import com.linestore.vo.Tag;

@Transactional
public class TagServiceImpl implements TagService {
	
	private TagDao tagDao;
	

	public TagDao getTagDao() {
		return tagDao;
	}


	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}


	@Override
	public List<Tag> queryAll() {
		return tagDao.queryAll();
	}


	@Override
	public void save(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.save(tag);
	}


	@Override
	public void update(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.update(tag);
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tagDao.delete(id);
	}


	@Override
	public Tag selectById(int id) {
		// TODO Auto-generated method stub
		return tagDao.selectById(id);
	}

}
