package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.model.Supplier;
@Component
@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;
    @Transactional
	@Override
	public boolean save(Supplier supplier) {
    	try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
    @Transactional
	@Override
	public List getAllSuppliers() {
			
			List list = (List)sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			return list;
		
	}
//    @Override
//    @Transactional
//    public Supplier getSingleSupplier(int supid) {
//        String hql = "from Supplier where supid=" + supid;
//        Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql).list();
//         
//        @SuppressWarnings("unchecked")
//        List supplier = (List) query;
//         
//        if (supplier != null && !supplier.isEmpty()) {
//            return (Supplier) supplier.get(0);
//        }
//         
//        return null;
//    }
	@Transactional
	
	@Override
	public Supplier getSingleSupplier(int supid) {
	
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(Supplier.class, supid);
	
		return supplier;
	}
	

	@Transactional
	@Override
	public void delete(int supid) {
		
		
			
	
			sessionFactory.getCurrentSession().delete(getSingleSupplier(supid));

	
		
	}
	@Transactional
	@Override
	public void update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		
	}



//public Supplier getSingleSupplier(int id) {
//	Session session = sessionFactory.openSession();
//	Supplier supplier = (Supplier) session.load(Supplier.class, id);
//	
//	return supplier;
//}
}