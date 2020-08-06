package api.application;

import java.math.BigDecimal;
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
import api.application.entity.Category;
import api.application.entity.Customer;
import api.application.entity.Product;
import api.application.entity.ProductImages;
import api.application.entity.Promotion;
import api.application.entity.Review;
import api.application.entity.Role;
import api.application.entity.WishList;
import api.application.repository.Repository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("product")
	private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(String... args) throws Exception {
		Category type = new Category("CATE01", "Fresh Vegestable");
		Product product = (Product)repository.read("PRODUCT01");
		Review review = new Review("RVSP01", 5, "OK product is good for health", "Customer 01", "thien23@gmail.com",
				"0873425233", product);
		product.addReview(review);
//		product.setProductImages(new ProductImages("mainpic", "pic1", "pic2", "pic3", "pic4"));
//		product.setPromotion(new Promotion(BigDecimal.ZERO));
		repository.update(product);
	}
}
