package com.niit.shopinngcart1.dao;

import java.util.List;

import com.niit.shopinngcart1.model.Product;

public interface ProductDao {
	public void add(Product product);
	public void edit(Product product);
	public void delete(int productid);
	public Product getsingleproduct(int productid);
	public List getAllProducts();

}
