package api.application.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.application.entity.Cart;
import api.application.entity.Product;
import api.application.service.Service;

@RestController("cart_controller")
public class CartController {
	@Autowired
	@Qualifier("cart_service")
	private Service<Cart> service;

	@GetMapping("/api/carts/{cart_id}/products")
	public ResponseEntity<?> getCart(@PathVariable String cart_id) {
		try {
			Cart cart = service.get(cart_id);
			Set<Product> products = cart.getProducts();
			return ResponseEntity.status(200).body(products);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@PutMapping("/api/carts/{cart_id}")
	public ResponseEntity<?> getCart(@PathVariable String cart_id, @RequestBody Product product) {
		try {
			Cart cart = service.get(cart_id);
			cart.addProduct(product);
			Cart update = service.update(cart_id, cart);
			return ResponseEntity.status(200).body(update);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}
