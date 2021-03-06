package api.application.entity;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.application.model.RoleInstance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "customer")
public class Customer extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean gender;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
	private Cart cart;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "user")
	private WishList wishList;
	@OneToMany(mappedBy = "order_id")
	private Set<Order> orders = new HashSet<>();

	@ConstructorProperties({ "name", "email", "phone", "address", "gender", "dob", "username", "password" })
	public Customer(String name, String email, String phone, String address, boolean gender, Date dob, String username,
			String password) {
		super(name, email, phone, address);
		this.gender = gender;
		this.dob = dob;
		this.setCart(new Cart("Cart for user " + this.getUser_id()));
		this.setWishList(new WishList("Wishlist for user " + this.getUser_id()));
		Account account = new Account(username, password);
		account.addRole(RoleInstance.ROLE_CUSTOMER);
		this.setAccount(account);
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

	@JsonIgnore
	public Set<Order> getOrders() {
		return this.orders;
	}
}
