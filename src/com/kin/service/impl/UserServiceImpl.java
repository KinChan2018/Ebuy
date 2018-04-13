package com.kin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kin.dao.BaseDAO;
import com.kin.entity.User;
import com.kin.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private BaseDAO<User> baseDAO;
	
	@Override
	public void saveUser(User user) {
		baseDAO.merge(user);
		
	}

	@Override
	public boolean existUserWithUserName(String userName) {
		String hql="select count(*) from User where userName=?";
		long count=baseDAO.count(hql,new Object[] {userName});
		if(count>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User login(User user) {
		List<Object> param=new ArrayList<Object>();
		StringBuffer hql=new StringBuffer(" from User u where u.userName=? and u.password=?");
		param.add(user.getUserName());
		param.add(user.getPassword());
		return baseDAO.get(hql.toString(), param);
	}

}
