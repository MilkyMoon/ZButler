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

}
