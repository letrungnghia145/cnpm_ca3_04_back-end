package api.application.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import api.application.entity.User;

@org.springframework.stereotype.Repository("user")
public class UserRepository implements Repository<User> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User create(User t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.create(t, session);
	}

	@Override
	public User read(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.read(id, session);
	}

	@Override
	public User update(User t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.update(t, session);
	}

	@Override
	public User delete(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.delete(id, session);
	}

	@Override
	public List<User> getAll() throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.getAll(session);
	}
}
