package com.kin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kin.dao.BaseDAO;
import com.kin.entity.PageBean;
import com.kin.entity.Product;
import com.kin.service.ProductService;
import com.kin.util.StringUtil;
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Resource
	private BaseDAO<Product> baseDAO;
	@Override
	public List<Product> findProductList(Product s_product, PageBean pageBean) {
		List<Object> param=new ArrayList<Object>();
		StringBuffer hql=new StringBuffer(" from Product");
		if(s_product!=null) {
			if(s_product.getBigType()!=null) {
				hql.append(" and bigType.id=?");
				param.add(s_product.getBigType().getId());
			}
			if(s_product.getSmallType()!=null) {
				hql.append(" and smallType.id=?");
				param.add(s_product.getSmallType().getId());
			}
			if(StringUtil.isNotEmpty(s_product.getName())) {
				hql.append(" and name like ?");
				param.add("%"+s_product.getName()+"%");
			}
			if(s_product.getSpecialPrice()==1) {
				hql.append(" and specialPrice=1 order by specialPriceTime desc");
			}
			if(s_product.getHot()==1) {
				hql.append(" and hot=1 order by hotTime desc");
			}
		}
		if(pageBean!=null){
			return baseDAO.find(hql.toString().replaceFirst("and", "where"), param, pageBean);
		}else {
			return null;
		}
	}
	@Override
	public Long getProductCount(Product s_product) {
		List<Object> param=new ArrayList<Object>();
		StringBuffer hql=new StringBuffer("select count(*) from Product");
		if(s_product!=null) {
			if(s_product.getBigType()!=null) {
				hql.append(" and bigType.id=?");
				param.add(s_product.getBigType().getId());
			}
			if(s_product.getSmallType()!=null) {
				hql.append(" and smallType.id=?");
				param.add(s_product.getSmallType().getId());
			}
			if(StringUtil.isNotEmpty(s_product.getName())) {
				hql.append(" and name like ?");
				param.add("%"+s_product.getName()+"%");
			}
		}
		return baseDAO.count(hql.toString().replaceFirst("and", "where"), param);
	}
	@Override
	public Product getProductById(int productId) {
		return baseDAO.get(Product.class, productId);
	}

}
