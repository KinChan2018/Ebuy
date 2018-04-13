package com.kin.service;

import java.util.List;

import com.kin.entity.Comment;
import com.kin.entity.PageBean;

public interface CommentService {

	public List<Comment> findCommentList(Comment s_Comment,PageBean pageBean);
	
	public Long getCommentCount(Comment s_Comment);
	
	public void saveComment(Comment comment);
	
}
