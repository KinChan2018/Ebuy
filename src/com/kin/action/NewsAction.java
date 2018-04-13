package com.kin.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.kin.entity.News;
import com.kin.service.NewsService;
import com.kin.util.NavUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class NewsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private NewsService newsService;
	
	private News news;
	private int newsId;
	private String mainPage;
	private String navCode;
	
	public String showNews()throws Exception{
		news=newsService.getNewsById(newsId);
		mainPage="news/newsDetails.jsp";
		navCode=NavUtil.genNavCode("新闻信息");
		return SUCCESS;
		
	}
	
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	
	public int getNewsId() {
		return newsId;
	}


	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}


	public String getMainPage() {
		return mainPage;
	}
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	public String getNavCode() {
		return navCode;
	}
	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}
	
	
	
}
