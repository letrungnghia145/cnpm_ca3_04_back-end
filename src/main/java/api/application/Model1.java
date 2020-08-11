package api.application;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Model1 {
	private String name;
	private String id;
	private Model2 model2;

	@ConstructorProperties({"name", "id", "model2"})
	public Model1(String name, String id, int model2) {
		System.out.println("called");
		this.name = name;
		this.id = id;
		if (model2 == 1) {
			this.model2 = new Model2("ada", "id");
		}
	}

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String content = "{\r\n" + "\"name\":\"model1\",\r\n" + "\"id\":\"IDS\",\r\n" + "\"model2\": 1\r\n" + "}";
		Model1 readValue = mapper.readValue(content, Model1.class);
		System.out.println(readValue.getModel2());
	}
}
