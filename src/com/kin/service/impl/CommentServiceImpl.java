package com.kin.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kin.dao.BaseDAO;
import com.kin.entity.Comment;
import com.kin.entity.PageBean;
import com.kin.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Resource
	private BaseDAO<Comment> baseDAO;
	
	@Override
	public List<Comment> findCommentList(Comment s_Comment, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Object> param=new LinkedList<Object>();
		StringBuffer hql=new StringBuffer(" from Comment");
		hql.append(" order by createTime desc");
		if(pageBean!=null) {
			return baseDAO.find(hql.toString(), param, pageBean);
		}else {
			return null;
		}
	}

	@Override
	public Long getCommentCount(Comment s_Comment) {
		// TODO Auto-generated method stub
		List<Object> param=new LinkedList<Object>();
		StringBuffer hql=new StringBuffer("select count(*) from Comment");
		return baseDAO.count(hql.toString(), param);
	}

	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		baseDAO.merge(comment);
	}

	
	
}
