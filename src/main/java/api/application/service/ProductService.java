package api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import api.application.entity.Product;
import api.application.repository.Repository;

@org.springframework.stereotype.Service("product_service")
public class ProductService implements Service<Product> {
	@Autowired
	@Qualifier("product_repository")
	private Repository<Product> repository;

	@Override
	public Product get(String id) throws Exception {
		return repository.read(id);
	}

	@Override
	public Product update(String id, Product entity) throws Exception {
		entity.setProduct_id(id);
		return repository.update(entity);
	}

	@Override
	public Product add(Product entity) throws Exception {
		return repository.create(entity);
	}

	@Override
	public Product delete(String id) throws Exception {
		return repository.delete(id);
	}

	@Override
	public List<Product> getAll() throws Exception {
		return repository.getAll();
	}
}
