package api.application.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import api.application.entity.Order;

@org.springframework.stereotype.Repository("order_repository")
public class OrderRepository implements Repository<Order> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Order create(Order t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.create(t, session);
	}

	@Override
	public Order read(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.read(id, session);
	}

	@Override
	public Order update(Order t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.update(t, session);
	}

	@Override
	public Order delete(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.delete(id, session);
	}

	@Override
	public List<Order> getAll() throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.getAll(session);
	}

	@Override
	public long countRows() throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.countRows(session);
	}

	@Override
	public List<Order> getResultByPage(int page, int resultPerPage) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
