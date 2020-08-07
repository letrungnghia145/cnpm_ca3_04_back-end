package api.application.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import api.application.entity.Account;

@org.springframework.stereotype.Repository("account")
public class AccountRepository implements Repository<Account> {
	@Autowired
	private SessionFactory sessionFactory;

	public Account findAccountByUsername(String username) throws Exception {
		Session session = sessionFactory.openSession();
		return (Account) useTransaction(session, () -> {
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

	@Override
	public List<Account> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
