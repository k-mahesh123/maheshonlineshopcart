package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.CategoryDao;
import com.niit.shopinngcart1.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory = sessionFactory;
	}
    @Transactional
	@Override
	public void add(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (HibernateException e) {
		
			e.printStackTrace();
		}

	}
    @Transactional
	@Override
	public void edit(Category category) {
		sessionFactory.getCurrentSession().update( category);
		

	}
    @Transactional
	@Override
	public void delete(int categoryid) {
		sessionFactory.getCurrentSession().delete(getsinglecategory(categoryid));

	}
    @Transactional
	@Override
	public Category getsinglecategory(int categoryid) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryid);
	}
    @Transactional
	@Override
	public List getAllCategorys() {
		return (List)sessionFactory.getCurrentSession().createQuery("from Category").list();
	
	}

}
