package api.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "wishlist")
public class WishList {
	@Id
	private String wlist_id;
	private String description;
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "wlist_product", joinColumns = @JoinColumn(name = "wlist_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
}
