package api.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("test")
	public ResponseEntity<?> getResponse(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		boolean check = authorization != null;
		return ResponseEntity.status(200).body(check + " " + authorization);
	}
}
