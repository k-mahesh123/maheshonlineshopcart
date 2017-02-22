package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.CartDao;
import com.niit.shopinngcart1.model.CartItem;
@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void add(CartItem cartItem) 
	{
		 sessionFactory.getCurrentSession().save(cartItem);
		//session.saveOrUpdate(item);
//		Session session=sessionFactory.openSession();
//		org.hibernate.Transaction tx=session.beginTransaction();
//		session.saveOrUpdate(cartItem);
//		tx.commit();
	}

	@Transactional
	public CartItem get(int id) {
	
		return (CartItem) sessionFactory.getCurrentSession().get(CartItem.class, id);		
	}

	@Transactional
	public List getAllItems()
	{
       
        return  (List)sessionFactory.getCurrentSession().createQuery("from CartItem").list();
	
	}
	@Transactional
	public void delete(int id)
	{
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		CartItem chartItem=(CartItem)session.load(CartItem.class, id);
		session.delete(chartItem);	
		tx.commit();
		session.close();
				
	}
	
	@Transactional
	public void removeAll() 
	{
		List<CartItem> cartItems = getAllItems();
		for(CartItem item: cartItems) 
		{
			delete(item.cartItemId);
		}
		
	}
	@Transactional
	public void update(int cartItemId,int quantity) 
	{
		Session session=sessionFactory.openSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		CartItem cartItem=(CartItem)session.load(CartItem.class, cartItemId);
	    session.saveOrUpdate(cartItem);
		tx.commit();
	}
}
