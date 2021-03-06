package api.application.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import api.application.model.RoleInstance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "admin")
public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	public Admin(String name, String email, String phone, String address, String username,
			String password) {
		super(name, email, phone, address);
		Account account = new Account(username, password);
		account.addRole(RoleInstance.ROLE_ADMIN);
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
}
