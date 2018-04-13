package com.kin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kin.dao.BaseDAO;
import com.kin.entity.ProductBigType;
import com.kin.service.ProductBigTypeService;
@Service("productBigTypeService")
public class ProductBigTypeServiceImpl implements ProductBigTypeService{

	@Resource
	private BaseDAO<ProductBigType> baseDAO;
	@Override
	public List<ProductBigType> findAllBigTypeList() {
		// TODO Auto-generated method stub
		return baseDAO.find(" from ProductBigType");
	}

}
