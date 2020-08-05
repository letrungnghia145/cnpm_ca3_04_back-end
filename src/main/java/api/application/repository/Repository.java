package api.application.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;

@org.springframework.stereotype.Repository
public interface Repository<T> {
	public T create(T t) throws Exception;

	public T read(String id) throws Exception;

	public T update(T t) throws Exception;

	public T delete(String id) throws Exception;

	@SuppressWarnings("unchecked")
	default T create(T t, Session session) throws Exception {
		return useTransaction(session, () -> {
			Serializable save = session.save(t);
			return (T) save;
		});
	};

	default T read(String id, Session session) throws Exception {
		return useTransaction(session, () -> {
			Class<T> clazz = getGenericType();
			T t = session.get(clazz, id);
			return t;
		});
	};

	default T update(T t, Session session) throws Exception {
		return useTransaction(session, () -> {
			session.update(t);
			return t;
		});
	};

	default T delete(String id, Session session) throws Exception {
		return useTransaction(session, () -> {
			Class<T> clazz = getGenericType();
			T temp = session.get(clazz, id);
			session.delete(temp);
			return temp;
		});
	};

	// default method to use transaction
	default T useTransaction(Session session, Functional<T> functional) {
		T t = null;
		try {
			session.beginTransaction();
			t = functional.applyBatch();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return t;
	}

	// default get implement Generic
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
