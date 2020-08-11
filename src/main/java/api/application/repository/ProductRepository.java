package api.application.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import api.application.entity.Product;

@org.springframework.stereotype.Repository("product_repository")
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

	@Override
	public List<Product> getAll() throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.getAll(session);
	}

	@Override
	public long countRows() throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.countRows(session);
	}

	@Override
	public List<Product> getResultByPage(int page, int resultPerPage) throws Exception {
		Session session = sessionFactory.openSession();
		int end = page * resultPerPage;
		int start = end - 10;
		return Repository.super.getByScope(session, start, end);
	}

}
