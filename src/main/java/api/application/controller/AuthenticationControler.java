package api.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.application.utils.JWTUtils;

@RestController
public class AuthenticationControler {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTUtils JWTUtils;
	@Autowired
	private UserDetailsService service;

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest request) {
		String username = request.getUsername();
		String password = request.getPassword();
		String token = null;
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			final UserDetails userDetails = service.loadUserByUsername(username);
			token = JWTUtils.generateToken(userDetails);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
