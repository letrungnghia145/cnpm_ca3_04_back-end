package api.application.repository;

public class Test {
	public static void main(String[] args) {
		Repository repository = new AccountRepository();
		System.out.println(repository.getGenericType().getSimpleName());
	}
}
