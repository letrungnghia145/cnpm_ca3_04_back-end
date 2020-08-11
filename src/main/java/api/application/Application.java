package api.application;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.application.entity.Cart;
import api.application.entity.Customer;
import api.application.entity.Product;
import api.application.entity.User;
import api.application.repository.Repository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("user_repository")
	private Repository repository;
	@Autowired
	@Qualifier("product_repository")
	private Repository product_repo;

	@Autowired
	private SessionFactory sessionFactory;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(String... args) throws Exception {
		
//		ObjectMapper mapper = new ObjectMapper();
//		List resultByPage = repository.getResultByPage(2, 10);
//		for (Object object : resultByPage) {
//			System.out.println(mapper.writeValueAsString(object));
//		}
		
//		String content = "{\r\n" + 
//				"    \"name\": \"Le Trung Nghia\",\r\n" + 
//				"    \"user_id\": \"\",\r\n" + 
//				"    \"email\": \"nghia1k45@gmail.com\",\r\n" + 
//				"    \"phone\": \"0868880758\",\r\n" + 
//				"    \"address\": \"Tay Ninh\",\r\n" + 
//				"    \"gender\": \"true\",\r\n" + 
//				"    \"dob\": 929293200000,\r\n" + 
//				"    \"username\": \"letrungnghia145\",\r\n" + 
//				"    \"password\": \"172285633\"\r\n" + 
//				"}";
////		Object read = repository.read("USER01");
//		
//		ObjectMapper mapper = new ObjectMapper();
//		User readValue = mapper.readValue(content, Customer.class);
//		Object create = repository.create(readValue);
//		System.out.println(mapper.writeValueAsString(create));
}
}
