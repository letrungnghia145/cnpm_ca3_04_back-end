package api.application.controller;

public class JwtResponse {
	private String token;

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
