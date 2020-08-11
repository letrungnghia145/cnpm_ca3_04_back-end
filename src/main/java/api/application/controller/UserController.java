package api.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.application.entity.User;
import api.application.service.Service;

@RestController("user_controller")
public class UserController implements Controller<User> {
	@Autowired
	@Qualifier("user_service")
	private Service<User> service;

	@Override
	public ResponseEntity<?> getObject(String objectID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateObject(User entity, String objectID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteObject(String objectID) {
		return null;
	}

	@Override
	@PostMapping("/users") 
	public ResponseEntity<?> createObject(User entity) {
		try {
			User object = service.add(entity);
			return ResponseEntity.status(HttpStatus.OK).body(object);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@Override
	@GetMapping("/users")
	public ResponseEntity<?> getAllObjects() {
		try {
			List<User> users = service.getAll();
			return ResponseEntity.status(HttpStatus.OK).body(users);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
