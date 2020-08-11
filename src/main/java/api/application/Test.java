package api.application;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.application.entity.Cart;
import api.application.entity.Customer;
import api.application.entity.Product;
import api.application.entity.User;

public class Test {
	public static void main(String[] args) throws Exception {
		String content = "{\r\n" + 
				"    \"name\": \"Duck’s egg\",\r\n" + 
				"    \"price\": 11.00,\r\n" + 
				"    \"type\": 6,\r\n" + 
				"    \"mfg\": 1596214800,\r\n" + 
				"    \"exp\": \"1 week\",\r\n" + 
				"    \"description\": \"  Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\",\r\n" + 
				"    \"stock\": 50,\r\n" + 
				"    \"evaluate\": 4,\r\n" + 
				"    \"promotion\": 0.02,\r\n" + 
				"    \"mainPic\": \"https://i.ibb.co/GtGmyTJ/trung-vit.png\",\r\n" + 
				"    \"pic_1\": \"\",\r\n" + 
				"    \"pic_2\": \"\",\r\n" + 
				"    \"pic_3\": \"\",\r\n" + 
				"    \"pic_4\": \"\"\r\n" + 
				"}";
		ObjectMapper mapper = new ObjectMapper();
		Product readValue = mapper.readValue(content, Product.class);
		System.out.println(readValue);

	}
}
