package api.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.application.entity.Customer;

public class ProductService {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String content = "{\"user_id\":\"USER01\",\"name\":\"Mai Dieu Thien\",\"email\":\"thien23@gmail.com\",\"phone\":\"0827342333\",\"address\":\"Tay Ninh\",\"account\":{\"account_id\":\"USER01\",\"username\":\"dieuthiencute\",\"password\":\"$2a$10$83t.XPuK6z3WVAM/H7J/GOyhRK4mOP4uIIUOrl8hlIWos7NK/V18.\",\"roles\":[{\"role_id\":\"ROLE02\",\"role_name\":\"ROLE_CUSTOMER\"}]},\"gender\":false,\"dob\":1596646800000,\"cart\":{\"cart_id\":\"USER01\",\"description\":\"CART for USER 01\",\"products\":[]},\"wishList\":{\"wlist_id\":\"USER01\",\"description\":\"WISHLIST for USER 01\",\"products\":[]}}";
		Customer customer = mapper.readValue(content, Customer.class);
		System.out.println(customer);
	}
}
