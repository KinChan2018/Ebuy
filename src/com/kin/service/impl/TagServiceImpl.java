package com.kin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kin.dao.BaseDAO;
import com.kin.entity.Tag;
import com.kin.service.TagService;
@Service("tagService")
public class TagServiceImpl implements TagService {
	
	@Resource
	private BaseDAO<Tag> baseDAO;
	
	@Override
	public List<Tag> findTagList() {
		StringBuffer hql=new StringBuffer(" from Tag");
		return baseDAO.find(hql.toString());
	}

}
