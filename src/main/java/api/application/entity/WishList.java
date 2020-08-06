package api.application.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

@Table(name = "wishlist")
public class WishList implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String wlist_id;
	private String description;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinTable(name = "wlist_product", joinColumns = @JoinColumn(name = "wlist_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<>();
	@OneToOne(fetch = FetchType.LAZY)
	@JsonBackReference("user_wishlist_ref")
	@MapsId
	private User user;

	public WishList(String description) {
		super();
		this.description = description;
	}

	public void addProduct(Product product) {
		products.add(product);
		product.getWishLists().add(this);
	}

	public void removeProduct(Product product) {
		products.remove(product);
		product.getWishLists().remove(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WishList))
			return false;
		return wlist_id != null && wlist_id.equals(((WishList) obj).getWlist_id());
	}

	@Override
	public int hashCode() {
		return 43;
	}
}
