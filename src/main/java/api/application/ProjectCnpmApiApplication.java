package api.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.application.entity.Account;
import api.application.entity.Cart;
import api.application.entity.Customer;
import api.application.entity.Product;
import api.application.entity.Role;
import api.application.entity.WishList;

@SpringBootApplication
public class ProjectCnpmApiApplication implements CommandLineRunner {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired

	public static void main(String[] args) {
		SpringApplication.run(ProjectCnpmApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		useSessionFactory();

	}

	private void useSessionFactory() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

//			save(session);
//			delete(session);

			session.getTransaction().commit();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
	}

	private void delete(Session session) {
		session.delete(new Role("ROLE01", "ROLE_ADMIN"));
		Customer customer = session.get(Customer.class, "CUSTOMER01");
		customer.setAccount(null);
		customer.setCart(null);
		session.delete(customer);
	}

	private void save(Session session) {
		Customer customer = new Customer("CUSTOMER01", "Le Trung Nghia", "nghia1k45@gmail.com", "0868880758",
				"Tay Ninh", true, new Date());
		Cart cart = new Cart("Cart for user 01");
		List<Product> products = new ArrayList<Product>();
		WishList wishList = new WishList("Wishlist for user 01", products);
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role("ROLE01", "ROLE_ADMIN");
		roles.add(role);
		session.save(role);
		Account account = new Account("nghia1k45", "172285633", roles);
		customer.setCart(cart);
		customer.setWishList(wishList);
		customer.setAccount(account);
		session.save(customer);
	}
}
