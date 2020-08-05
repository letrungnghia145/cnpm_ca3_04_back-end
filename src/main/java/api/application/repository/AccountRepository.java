package api.application.repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import api.application.entity.Account;

@org.springframework.stereotype.Repository("account")
public class AccountRepository implements Repository<Account> {
	@Autowired
	private SessionFactory sessionFactory;

	public Account findAccountByUsername(String username) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Query query = session.createQuery("FROM Account WHERE username = :username");
			query.setParameter("username", username);
			return (Account) query.getSingleResult();
		});
	}

	@Override
	public Account create(Account t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.create(t, session);
	}

	@Override
	public Account read(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.read(id, session);
	}

	@Override
	public Account update(Account t) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.update(t, session);
	}

	@Override
	public Account delete(String id) throws Exception {
		Session session = sessionFactory.openSession();
		return Repository.super.delete(id, session);
	}
}
