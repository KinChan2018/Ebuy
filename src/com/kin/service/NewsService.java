package com.kin.service;

import java.util.List;

import com.kin.entity.News;
import com.kin.entity.PageBean;

public interface NewsService {

	public List<News> findnewsList(News s_news,PageBean pageBean);
	
	public News getNewsById(int newsId);
	
}
