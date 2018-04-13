package com.kin.service;

import java.util.List;

import com.kin.entity.Notice;
import com.kin.entity.PageBean;

public interface NoticeService {

	public List<Notice> findNoticeList(Notice s_notice,PageBean pageBean);
	
	public Notice getNoticeById(int noticeId);
	
}
