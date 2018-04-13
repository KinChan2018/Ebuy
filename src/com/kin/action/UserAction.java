package com.kin.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.kin.entity.User;
import com.kin.service.UserService;
import com.kin.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class UserAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	
	@Resource
	private UserService userService;
	
	private String userName;
	private User user;
	private String error;
	
	private String imageCode;
	
	public String existUserWithUserName()throws Exception{
		boolean exist=userService.existUserWithUserName(userName);
		JSONObject result=new JSONObject();
		if(exist) {
			result.put("exist",true);
		}else {
			result.put("exist", false);
		}
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
	}
	
	public String logout()throws Exception{
		request.getSession().invalidate();
		return "logout";
	}
	
	public String register()throws Exception{
		userService.saveUser(user);
		return "register_success";
		
	}
	public String login()throws Exception{
		HttpSession session=request.getSession();
		User currentUser=userService.login(user);
		if(!imageCode.equals(session.getAttribute("sRand"))) {
			error="验证码错误！";
			return ERROR;
		}else if(currentUser==null) {
			error="用户名或者密码错误！";
			return ERROR;
		}else {
			session.setAttribute("currentUser", currentUser);
			return "login";
		}
	}
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	
}
