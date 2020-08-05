package api.application.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "orders")
public class Order {
	@Id
	private String order_id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePurchase;
	private int status;
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "user_id")
	private Customer customer;
	@JsonManagedReference
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;

	public void addProduct(Product product) {
		products.add(product);
		product.getOrders().add(this);
	}

	public void removeProduct(Product product) {
		products.remove(product);
		product.getOrders().remove(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Order))
			return false;
		return order_id != null && order_id.equals(((Order) obj).getOrder_id());
	}

	@Override
	public int hashCode() {
		return 37;
	}
}
