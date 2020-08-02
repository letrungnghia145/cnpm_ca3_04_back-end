package api.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
	@GetMapping("/{id}")
	public ResponseEntity<?> getCart(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

	@GetMapping("")
	public ResponseEntity<?> getAllCarts() {
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

	@PostMapping("")
	public ResponseEntity<?> createCart() {
		return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCart(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}

}
