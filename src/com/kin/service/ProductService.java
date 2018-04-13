package com.kin.service;

import java.util.List;

import com.kin.entity.PageBean;
import com.kin.entity.Product;

public interface ProductService {

	public List<Product> findProductList(Product s_product,PageBean pageBean);
	
	public Long getProductCount(Product s_product);
	
	public Product getProductById(int productId);
	
}
