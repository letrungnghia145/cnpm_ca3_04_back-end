package api.application.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "admin")
public class Admin extends User implements Serializable{
	private static final long serialVersionUID = 1L;

	public Admin(String user_id, String name, String email, String phone, String address) {
		super(user_id, name, email, phone, address);
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
