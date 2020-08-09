package api.application.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "cart")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String cart_id;
	private String description;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> products = new HashSet<>();
	@JsonBackReference("user_cart_ref")
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;

	public Cart(String description) {
		super();
		this.description = description;
	}

	public void addProduct(Product product) {
		products.add(product);
		product.getCarts().add(this);
	}

	public void removeProduct(Product product) {
		products.remove(product);
		product.getCarts().remove(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cart))
			return false;
		return cart_id != null && cart_id.equals(((Cart) obj).getCart_id());
	}

	@Override
	public int hashCode() {
		return 53;
	}
}
