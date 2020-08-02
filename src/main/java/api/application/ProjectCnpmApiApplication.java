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

//			get(session);
			
//			delete(session);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
	}

	private void delete(Session session) {
		session.delete(session.get(Customer.class, "USER01"));
	}

	private void get(Session session) {
		Customer customer = session.get(Customer.class, "USER01");
		System.out.println(customer.getAccount());
		System.out.println(customer.getCart());
		System.out.println(customer.getWishList());
	}

	private void save(Session session) {
		List<Role> roles = new ArrayList<>();
		Role role_admin = new Role("ROLE01", "ADMIN");
		roles.add(role_admin);
		Account account = new Account("ACCOUNT01", "pyn_xd_2k@yahoo.com", "172285633", roles);
		Cart cart = new Cart("CART01", "Cart for user 01");
		List<Product> products = new ArrayList<Product>();
		WishList wishList = new WishList("WLIST01", "WishList for user 1", products);
		Customer customer = new Customer("USER01", "nghia", "nghia1k45@gmail.com", "0868880758", "Tay Ninh", account,
				true, new Date(), cart, wishList);
		session.save(account);
		session.save(cart);
		session.save(wishList);
		session.save(customer);
		session.save(role_admin);
//		session.update(account);
//		session.update(customer);
	}
}
