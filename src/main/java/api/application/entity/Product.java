package api.application.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "product")
public class Product {
	@Id
	private String product_id;
	private String name;
	private BigDecimal price;
	@OneToOne
	private ProductImages images;
	@OneToOne
	private Category type;
	@Temporal(TemporalType.DATE)
	private Date mfg;
	private String exp;
	private String description;
	private int stock;
	private int evaluate;
	@OneToOne
	private Promotion promotion;
	@OneToMany(mappedBy = "product")
	private List<Review> reviews;
	@ManyToMany(mappedBy = "products")
	private List<WishList> wishLists;
	@ManyToMany(mappedBy = "products")
	private List<Order> orders;

	public Product(String product_id, String name, BigDecimal price, ProductImages images, Category type, Date mfg,
			String exp, String description, int stock, int evaluate, Promotion promotion) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.images = images;
		this.type = type;
		this.mfg = mfg;
		this.exp = exp;
		this.description = description;
		this.stock = stock;
		this.evaluate = evaluate;
		this.promotion = promotion;
	}
}
