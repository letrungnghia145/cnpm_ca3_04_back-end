package api.application.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

@Table(name = "customer")
public class Customer extends User {
	private boolean gender;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@OneToOne(cascade = CascadeType.REMOVE)
	private Cart cart;
	@OneToOne(cascade = CascadeType.REMOVE)
	private WishList wishList;
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public Customer(String user_id, String name, String email, String phone, String address, Account account,
			boolean gender, Date dob, Cart cart, WishList wishList) {
		super(user_id, name, email, phone, address, account);
		this.gender = gender;
		this.dob = dob;
		this.cart = cart;
		this.wishList = wishList;
	}
}
