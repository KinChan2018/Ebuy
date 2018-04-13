package com.kin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kin.dao.BaseDAO;
import com.kin.entity.News;
import com.kin.entity.PageBean;
import com.kin.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService{

	@Resource
	private BaseDAO<News> baseDAO;

	@Override
	public List<News> findnewsList(News s_news, PageBean pageBean) {
		List<Object> param=new ArrayList<Object>();
		StringBuffer hql=new StringBuffer(" from News");
		if(pageBean!=null) {
			return baseDAO.find(hql.toString(), param, pageBean);
		}else {
			return null;
		}
	}

	@Override
	public News getNewsById(int newsId) {
		return baseDAO.get(News.class, newsId);
	}
	
	
	
	
}
