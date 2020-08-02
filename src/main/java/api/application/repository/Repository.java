package api.application.repository;

@org.springframework.stereotype.Repository
public interface Repository {
	public <T> T read(String id);
}
