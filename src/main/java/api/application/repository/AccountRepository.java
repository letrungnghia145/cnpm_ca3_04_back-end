package api.application.repository;

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

		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account delete(Account t) {
		// TODO Auto-generated method stub
		return null;
	}
}
