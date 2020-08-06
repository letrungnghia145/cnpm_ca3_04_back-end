package api.application.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import api.application.entity.Product;

@org.springframework.stereotype.Repository("product")
public class ProductRepository implements Repository<Product> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product create(Product t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.create(t, session);
	}

	@Override
	public Product read(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.read(id, session);
	}

	@Override
	public Product update(Product t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.update(t, session);
	}

	@Override
	public Product delete(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.delete(id, session);
	}

}
