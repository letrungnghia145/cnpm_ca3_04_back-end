package api.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.application.repository.Repository;

@RestController
public class UserController {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("user")
	private Repository repository;

	@PostMapping("login")
	public ResponseEntity<?> getInfoUserLoggedIn(HttpServletRequest request) throws Exception {
		String header = request.getHeader("Authorization");
		String token = null;
		if (header != null && header.startsWith("Bearer ")) {
			token = header.substring(7);
			Object read = repository.read("USER01");
//			System.out.println(read);
			return ResponseEntity.status(HttpStatus.OK).body(read);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Entity found");
	}
}
