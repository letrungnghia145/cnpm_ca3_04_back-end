package api.application.service;

@org.springframework.stereotype.Service
public interface Service<T> {
	public T get();

	public T put();

	public T post();

	public T delete();
}
