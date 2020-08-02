package api.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "cart_item")
public class CartItem {
	@Id
	private String item_id;
	@OneToOne
	private Product product;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
}
