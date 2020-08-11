package api.application.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

@org.springframework.stereotype.Repository
public interface Repository<T> {
	public T create(T t) throws Exception;

	public T read(String id) throws Exception;

	public T update(T t) throws Exception;

	public T delete(String id) throws Exception;

	public List<T> getAll() throws Exception;

	public long countRows() throws Exception;

	public List<T> getResultByPage(int page, int resultPerPage) throws Exception;

	@SuppressWarnings("unchecked")
	default T create(T t, Session session) throws Exception {
		return (T) useTransaction(session, () -> {
			session.save(t);
			return t;
		});
	};

	@SuppressWarnings("unchecked")
	default T read(String id, Session session) throws Exception {
		return (T) useTransaction(session, () -> {
			Class<T> clazz = getGenericType();
			T t = session.get(clazz, id);
			return t;
		});
	};

	@SuppressWarnings("unchecked")
	default T update(T t, Session session) throws Exception {
		return (T) useTransaction(session, () -> {
			session.update(t);
			return t;
		});
	};

	@SuppressWarnings("unchecked")
	default T delete(String id, Session session) throws Exception {
		return (T) useTransaction(session, () -> {
			Class<T> clazz = getGenericType();
			T temp = session.get(clazz, id);
			session.delete(temp);
			return temp;
		});
	};

	@SuppressWarnings("unchecked")
	default List<T> getAll(Session session) throws Exception {
		return (List<T>) useTransaction(session, () -> {
			String className = getGenericType().getSimpleName();
			Query query = session.createQuery("FROM " + className);
			return query.getResultList();
		});
	};

	default long countRows(Session session) throws Exception {
		return (Long) useTransaction(session, () -> {
			String className = getGenericType().getSimpleName();
			Query query = session.createQuery("SELECT COUNT(" + className.toLowerCase() + "_id) FROM " + className);
			return query.getSingleResult();
		});
	};

	@SuppressWarnings("unchecked")
	default List<T> getByScope(Session session, int start, int end) throws Exception {
		return (List<T>) useTransaction(session, () -> {
			String className = getGenericType().getSimpleName();
			Query query = session.createQuery("FROM " + className);
			query.setFirstResult(start);
			query.setMaxResults(end);
			return query.getResultList();
		});
	};

	// default method to use transaction
	default Object useTransaction(Session session, Functional<Object> functional) throws Exception {
		Object t = null;
		try {
			session.beginTransaction();
			t = functional.applyBatch();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			session.close();
		}
		return t;
	}

	// default method to get implement class's Generic
	@SuppressWarnings("unchecked")
	default Class<T> getGenericType() {
		Class<T> clazz = null;
		Type[] genericInterfaces = this.getClass().getGenericInterfaces();
		for (Type genericInterface : genericInterfaces) {
			if (genericInterface instanceof ParameterizedType) {
				Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
				for (Type genericType : genericTypes) {
					clazz = (Class<T>) genericType;
				}
			}
		}
		return clazz;
	}

}
