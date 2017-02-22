package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.ProductDao;
import com.niit.shopinngcart1.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
    @Transactional
	@Override
	public void add(Product product) {
		sessionFactory.getCurrentSession().save( product);

	}
    @Transactional
	@Override
	public void edit(Product product) {
		sessionFactory.getCurrentSession().update( product);
		

	}
    @Transactional
	@Override
	public void delete(int productid) {
		sessionFactory.getCurrentSession().delete(getsingleproduct(productid));

	}
    @Transactional
	@Override
	public Product getsingleproduct(int productid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productid);
	}
    @Transactional
	@Override
	public List getAllProducts() {
		return (List)sessionFactory.getCurrentSession().createQuery("from Product").list();
	
	}

}
