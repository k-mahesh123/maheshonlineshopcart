package com.niit.shopinngcart1.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shopinngcart1.model.CartItem;
@Component
public interface CartDao {
	public void add(CartItem cartItem);
	public CartItem get(int id);
	public List getAllItems();
	public void delete(int id);
	public void removeAll();
	public void update(int cartItemId,int quantity);
	

}
