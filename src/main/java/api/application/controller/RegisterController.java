package api.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.application.entity.Customer;
import api.application.entity.User;
import api.application.service.Service;

@RestController
public class RegisterController {
	@Autowired
	@Qualifier("user_service")
	private Service<User> service;

	@PostMapping("/register")
	public ResponseEntity<?> authenticate(@RequestBody Customer user) {
		try {
			Object object = service.add(user);
			return ResponseEntity.status(HttpStatus.OK).body(object);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}
