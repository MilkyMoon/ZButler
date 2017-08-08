package com.linestore.action;

import java.util.List;

import com.linestore.service.NoticeService;
import com.linestore.vo.Message;
import com.linestore.vo.Notice;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice> {
	// 模型驱动使用的类
	private Notice notice = new Notice();

	@Override
	public Notice getModel() {
		// TODO Auto-generated method stub
		if (notice == null) {
			notice = new Notice();
		}
		return notice;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	private NoticeService noticeService;

	public void selectAll() {
		System.out.println("select");
		noticeService.customerNewNoticesCenter().toString();
	}
}
