package api.application.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String product_id;
	@NaturalId
	private String name;
	private BigDecimal price;
	@JsonManagedReference("product_images_ref")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	private ProductImages images;
	@OneToOne
	private Category type;
	@Temporal(TemporalType.DATE)
	private Date mfg;
	private String exp;
	private String description;
	private int stock;
	private int evaluate;
	@JsonManagedReference("product_promotion_ref")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	private Promotion promotion;
	@JsonManagedReference("product_reviews_ref")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<Review>();
	@JsonBackReference("wishlist_products_ref")
	@ManyToMany(mappedBy = "products")
	private List<WishList> wishLists;
	@JsonBackReference("order_products_ref")
	@ManyToMany(mappedBy = "products")
	private List<Order> orders;
	@JsonBackReference("cart_products_ref")
	@ManyToMany(mappedBy = "products")
	private List<Cart> carts;

	public Product(String product_id, String name, BigDecimal price, Category type, Date mfg, String exp,
			String description, int stock, int evaluate, BigDecimal promotion, String mainPic, String pic_1,
			String pic_2, String pic_3, String pic_4) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.mfg = mfg;
		this.exp = exp;
		this.description = description;
		this.stock = stock;
		this.evaluate = evaluate;
		this.setPromotion(new Promotion(promotion));
		this.setProductImages(new ProductImages(mainPic, pic_1, pic_2, pic_3, pic_4));
	}

	public void setProductImages(ProductImages images) {
		if (images == null) {
			if (this.images != null) {
				this.images.setProduct(null);
			}
		} else {
			images.setProduct(this);
		}
		this.images = images;
	}

	public void setPromotion(Promotion promotion) {
		if (promotion == null) {
			if (this.promotion != null) {
				this.promotion.setProduct(null);
			}
		} else {
			promotion.setProduct(this);
		}
		this.promotion = promotion;
	}

	public void addReview(Review review) {
		reviews.add(review);
		review.setProduct(this);
	}

	public void removeReview(Review review) {
		reviews.remove(review);
		review.setProduct(null);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product product = (Product) obj;
		return Objects.equals(product.name, name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
