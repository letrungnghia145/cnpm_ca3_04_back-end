package api.application.repository;

import org.springframework.stereotype.Repository;

import api.application.entity.Product;

@Repository("product")
public class ProductRepository implements api.application.repository.Repository<Product> {

	@Override
	public Product create(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product delete(Product t) {
		// TODO Auto-generated method stub
		return null;
	}


}
