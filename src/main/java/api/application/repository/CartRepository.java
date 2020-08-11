package api.application.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import api.application.entity.Cart;

@org.springframework.stereotype.Repository("cart_repository")
public class CartRepository implements Repository<Cart> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Cart create(Cart t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.create(t, session);
	}

	@Override
	public Cart read(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.read(id, session);
	}

	@Override
	public Cart update(Cart t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.update(t, session);
	}

	@Override
	public Cart delete(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.delete(id, session);
	}

	@Override
	public List<Cart> getAll() throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.getAll(session);
	}

	@Override
	public long countRows() throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.countRows(session);
	}

	@Override
	public List<Cart> getResultByPage(int page, int resultPerPage) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
