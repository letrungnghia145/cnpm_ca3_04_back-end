package api.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> items;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;

	public Cart(String description) {
		super();
		this.description = description;
	}

	public void addItem(CartItem item) {
		items.add(item);
		item.setCart(this);
	}

	public void removeItem(CartItem item) {
		items.remove(item);
		item.setCart(null);
	}
}
