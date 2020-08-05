package api.application;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.application.entity.Account;
import api.application.entity.Admin;
import api.application.entity.Cart;
import api.application.entity.Customer;
import api.application.entity.Role;
import api.application.entity.WishList;
import api.application.repository.Repository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("user")
	private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(String... args) throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		Admin admin = new Admin("USER02", "Le Trung Nghia", "nghia1k45@gmail.com", "0868880758", "Tay Ninh");
		Account account = new Account("nghia1k45", encoder.encode("172285633"));
		account.addRole(new Role("ROLE01", "ROLE_ADMIN"));
		admin.setAccount(account);
		repository.create(admin);
	}
}
