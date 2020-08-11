package api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import api.application.entity.Cart;
import api.application.repository.Repository;


@org.springframework.stereotype.Service("cart_service")
public class CartService implements Service<Cart> {
	@Autowired
	@Qualifier("cart_repository")
	private Repository<Cart> repository;

	@Override
	public Cart get(String id) throws Exception {
		return repository.read(id);
	}

	@Override
	public Cart update(String id, Cart entity) throws Exception {
		entity.setCart_id(id);
		return repository.update(entity);
	}

	@Override
	public Cart add(Cart entity) throws Exception {
		return repository.create(entity);
	}

	@Override
	public Cart delete(String id) throws Exception {
		return repository.delete(id);
	}

	@Override
	public List<Cart> getAll() throws Exception {
		return repository.getAll();
	}

}
