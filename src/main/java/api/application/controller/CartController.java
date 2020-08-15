package api.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import api.application.entity.Cart;
import api.application.entity.Product;
import api.application.repository.Repository;
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
			return ResponseEntity.status(200).body(cart.getProducts());
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}
