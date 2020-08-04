package api.application;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTest implements CommandLineRunner {
//	@SuppressWarnings("rawtypes")
//	@Autowired
//	@Qualifier("customer")
//	private Repository repository;
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public void run(String... args) throws Exception {
		// List<Role> roles = new ArrayList<Role>();
//		Role role_admin = new Role("ROLE01", "ROLE_ADMIN");
//		Role role_customer = new Role("ROLE02", "ROLE_CUSTOMER");
//		roles.add(role_admin);
//		roles.add(role_customer);
//		Account account = new Account("ACCOUNT01", "letrungnghia", "172285633", roles);
//		Cart cart = new Cart("CART01", "CART FOR USER 01");
//		List<Product> products = new ArrayList<>();
//		WishList wishList = new WishList("WLIST01", "WISHLIST FOR USER 01", products);
//		Customer customer = new Customer("CUSTOMER01", "nghia", "nghia1k45", "0868880758", "Tay Ninh", account, true,
//				new Date(), cart, wishList);
//		repository.create(customer);

//		save();
//		delete("CUSTOMER01");
	}

//	private void delete(String id) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Customer customer = session.get(Customer.class, id);
//		customer.setAccount(null);
//		customer.setCart(null);
//		session.delete(customer);
//		session.getTransaction().commit();
//		session.close();
//	}
//
//	private void save() {
//		Customer customer = new Customer("CUSTOMER01", "nghia", true);
//		Account account = new Account("nghia1k45", "172285633");
//		customer.setAccount(account);
//		Cart cart = new Cart("Cart for user 01");
//		customer.setCart(cart);
//
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(customer);
//		session.getTransaction().commit();
//		session.close();
//	}
}
