package api.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.application.entity.User;
import api.application.model.JwtWrapper;
import api.application.model.UsernamePasswordWrapper;
import api.application.service.Service;
import api.application.service.UserService;
import api.application.utils.JWTUtils;

@RestController
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTUtils JWTUtils;
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("user_service")
	private Service service;

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody UsernamePasswordWrapper wrapper) {
		String username = wrapper.getUsername();
		String password = wrapper.getPassword();
		String token = null;
		try {
			if (service instanceof UserDetailsService) {
				UserDetailsService service = (UserDetailsService) this.service;
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				final UserDetails userDetails = service.loadUserByUsername(username);
				token = JWTUtils.generateToken(userDetails);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.ok(new JwtWrapper(token));
	}
	@PostMapping("/authorization")
	public ResponseEntity<?> authorization() {
		User user = null;
		try {
			if (service instanceof UserService) {
				UserService service = (UserService) this.service;
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String username = authentication.getName();
				user = service.getInfomationByUsername(username);
			}
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}
