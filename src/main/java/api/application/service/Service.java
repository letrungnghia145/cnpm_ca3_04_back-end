package api.application.service;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service<Entity> {
	public Entity get(String id) throws Exception;

	public Entity update(String id, Entity entity) throws Exception;

	public Entity add(Entity entity) throws Exception;

	public Entity delete(String id) throws Exception;

	public List<Entity> getAll() throws Exception;
}
