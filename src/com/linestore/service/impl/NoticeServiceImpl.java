package com.linestore.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.NoticeDao;
import com.linestore.service.NoticeService;
import com.linestore.util.Page;
import com.linestore.vo.Notice;

@Transactional
public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao;

	@Override
	public void delNotice(int id) {
		// TODO Auto-generated method stub
		noticeDao.delete(id);

	}

	@Override
	public void pushNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.addNotice(notice);
	}

	@Override
	public List<Notice> allNoticesCenter(Page page) {
		// TODO Auto-generated method stub

		return noticeDao.selectAll(page);
	}

	@Override
	public List<Notice> customerNewNoticesCenter() {
		// TODO Auto-generated method stub
		noticeDao.selectNew();
		return null;
	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

}
