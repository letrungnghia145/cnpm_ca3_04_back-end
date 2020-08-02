package api.application.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.application.entity.Account;

@Repository("account")
public class AccountRepository implements api.application.repository.Repository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public <T> T read(String id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.get(Account.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
