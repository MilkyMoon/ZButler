package com.linestore.service;

import java.util.List;

import com.linestore.vo.Pictures;

public interface PicturesService {

	public void addPicture(Pictures pic);

	public void updatePicture(String hql);

	public void delPicture(int id);

	public List<Pictures> queryByOtherId(int id);

}
