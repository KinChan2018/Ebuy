package com.kin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kin.dao.BaseDAO;
import com.kin.entity.Notice;
import com.kin.entity.PageBean;
import com.kin.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Resource
	private BaseDAO<Notice> baseDAO;

	@Override
	public List<Notice> findNoticeList(Notice s_notice, PageBean pageBean) {
		List<Object> param=new ArrayList<Object>();
		StringBuffer hql=new StringBuffer(" from Notice");
		if(pageBean!=null) {
			 return baseDAO.find(hql.toString(), param, pageBean);
		}else {
			return null;
		}
	}

	@Override
	public Notice getNoticeById(int noticeId) {
		return baseDAO.get(Notice.class, noticeId);
	}
	

}
