package com.linestore.service;

import java.util.List;

import com.linestore.util.Page;
import com.linestore.vo.Notice;

public interface NoticeService {
	public void delNotice(int id);

	public void pushNotice(Notice notice);

	public List<Notice> allNoticesCenter(Page page);

	public List<Notice> customerNewNoticesCenter();

}
