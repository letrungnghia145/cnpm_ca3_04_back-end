package api.application.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "cart")
public class Cart {
	@Id
	private String cart_id;
	private String description;
	@OneToMany(mappedBy = "cart")
	private List<CartItem> items;

	public Cart(String cart_id, String description) {
		super();
		this.cart_id = cart_id;
		this.description = description;
	}
}
