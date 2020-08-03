package api.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.application.entity.Account;
import api.application.entity.Role;
import api.application.repository.Repository;

@SpringBootApplication
public class SpringBootTest implements CommandLineRunner {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("product")
	private Repository repository;

	@SuppressWarnings("unchecked")
	@Override
	public void run(String... args) throws Exception {
		List<Role> roles = new ArrayList<Role>();
//		roles.add(new Role("ROLE01", "ADMIN"));
//		roles.add(new Role("ROLE02", "CUSTOMER"));
////		System.out.println(repository.read("ACCOUNT01"));
//		Account account = new Account("ACCOUNT02", "letrungnghia145", "172285633", roles);
//		repository.create(account);
//		ObjectMapper mapper = new ObjectMapper();
//		System.out.println(mapper.writeValueAsString(account));
		
//		repository.delete("ACCOUNT01");
//		repository.methods(null);
//		repository.create(null);
		
	}
}
