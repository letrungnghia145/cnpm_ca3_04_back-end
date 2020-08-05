package api.application.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
	private Cart cart;
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
	private WishList wishList;
	@JsonBackReference
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public Customer(String user_id, String name, String email, String phone, String address, boolean gender, Date dob) {
		super(user_id, name, email, phone, address);
		this.gender = gender;
		this.dob = dob;
	}

	public void setAccount(Account account) {
		if (account == null) {
			if (this.account != null) {
				this.account.setUser(null);
			}
		} else {
			account.setUser(this);
		}
		this.account = account;
	}

	public void setCart(Cart cart) {
		if (cart == null) {
			if (this.cart != null) {
				this.cart.setUser(null);
			}
		} else {
			cart.setUser(this);
		}
		this.cart = cart;
	}

	public void setWishList(WishList wishList) {
		if (wishList == null) {
			if (this.wishList != null) {
				this.wishList.setUser(null);
			}
		} else {
			wishList.setUser(this);
		}
		this.wishList = wishList;
	}
}
