package api.application.repository;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.application.entity.Account;

@Repository("account")
public class AccountRepository implements api.application.repository.Repository<Account> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account create(Account t) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			session.save(t);
			return t;
		});
	}

	@Override
	public Account read(String id) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Account account = session.get(Account.class, id);
			return account;
		});
	}

	@Override
	public Account update(Account t) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Account account = session.get(Account.class, t.getAccount_id());
			account = t;
			session.update(account);
			return account;
		});
	}

	@Override
	public Account delete(String id) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Account account = session.get(Account.class, id);
			session.delete(account);
			return account;
		});
	}

	public Account findAccountByUsername(String username) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Query query = session.createQuery("FROM Account WHERE username = :username");
			query.setParameter("username", username);
			return (Account) query.getSingleResult();
		});
	}
}
