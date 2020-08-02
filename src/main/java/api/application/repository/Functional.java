package api.application.repository;

@FunctionalInterface
public interface Functional<T> {
	public T applyBatch();
}
