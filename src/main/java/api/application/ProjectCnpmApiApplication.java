package api.application;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.application.entity.Account;
import api.application.entity.Cart;
import api.application.entity.Customer;
import api.application.entity.Role;
import api.application.entity.WishList;
import api.application.repository.Repository;

@SpringBootApplication
public class ProjectCnpmApiApplication implements CommandLineRunner {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("account")
	private Repository repository;
	@Autowired
	private SessionFactory sessionFactory;

	public static void main(String[] args) {
		SpringApplication.run(ProjectCnpmApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		save(sessionFactory.openSession());
//		Object read = repository.read("CUSTOMER01");
//		ObjectMapper mapper = new ObjectMapper();
//		System.out.println(mapper.writeValueAsString(read));
	}

	@SuppressWarnings("unchecked")
	private void save(Session session) throws Exception {
		Object object = repository.useTransaction(session, () -> {
//			PasswordEncoder encoder = new BCryptPasswordEncoder();
//			Customer customer = new Customer("CUSTOMER01", "Le Trung Nghia", "nghia1k45@gmail.com", "0868880758",
//					"Tay Ninh", true, new Date());
//			Cart cart = new Cart("CART for CUSTOMER 01");
//			WishList wishList = new WishList("WISHLIST for CUSTOMER 01");
//			Account account = new Account("nghia1k45", encoder.encode("172285633"));
//			Role role = new Role("ROLE01", "ROLE_ADMIN");
//			account.addRole(role);
//			customer.setCart(cart);
//			customer.setWishList(wishList);
//			customer.setAccount(account);
//			session.save(customer);

			Customer customer = session.get(Customer.class, "CUSTOMER01");
			return customer;
		});
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(object));
	}
}
