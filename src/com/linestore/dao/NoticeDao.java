package com.linestore.dao;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Notice;

public interface NoticeDao {
	public List<Notice> selectAll(Page page);

	public void addNotice(Notice notice);

	public List<Notice> selectNew();

	public void delete(int id);

	public int queryAll();

	public int getNewNoticeCount();

}
