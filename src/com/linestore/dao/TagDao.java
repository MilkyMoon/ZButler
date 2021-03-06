package com.linestore.dao;

import java.util.List;

import com.linestore.vo.Tag;

public interface TagDao {
	
	public List<Tag> queryAll();
	public void save(Tag tag);
	public void update(Tag tag);
	public void delete(int id);
	public Tag selectById(int id);
}
