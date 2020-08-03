package api.application.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import api.application.entity.Product;

@Repository("product")
public class ProductRepository implements api.application.repository.Repository<Product> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product create(Product t) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			session.save(t);
			return t;
		});
	}

	@Override
	public Product read(String id) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Product product = session.get(Product.class, id);
			return product;
		});
	}

	@Override
	public Product update(Product t) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Product product = session.get(Product.class, t.getProduct_id());
			product = t;
			session.update(t);
			return product;
		});
	}

	@Override
	public Product delete(String id) {
		Session session = sessionFactory.openSession();
		return useTransaction(session, () -> {
			Product product = session.get(Product.class, id);
			session.delete(product);
			return product;
		});
	}

}
