package api.application.repository;

import org.springframework.stereotype.Repository;

@Repository("product")
public class ProductRepository implements api.application.repository.Repository {

	@Override
	public <T> T read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
