package api.application.entity;

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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "wishlist")
public class WishList {
	@Id
	private String wlist_id;
	private String description;
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "wlist_product", joinColumns = @JoinColumn(name = "wlist_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;

	public WishList(String description, List<Product> products) {
		super();
		this.description = description;
		this.products = products;
	}
}
