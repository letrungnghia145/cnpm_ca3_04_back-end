package api.application.repository;

import org.hibernate.Session;

@org.springframework.stereotype.Repository
public interface Repository<T> {
	public T create(T t);

	public T read(String id);

	public T update(T t);

	public T delete(String id);

	// default method to use transaction
	default T useTransaction(Session session, Functional<T> functional) {
		T t = null;
		try {
			session.beginTransaction();
			t = functional.applyBatch();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return t;
	}
}
