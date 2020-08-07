package api.application.entity;

import java.io.Serializable;
import java.util.ArrayList;
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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String account_id;
	private String username;
	private String password;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JsonBackReference(value = "user_account_ref")
	private User user;

	public Account(String username, String password) {
		super();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		this.username = username;
		this.password = encoder.encode(password);
	}

	public void addRole(Role role) {
		roles.add(role);
		role.getAccounts().add(this);
	}

	public void removeRole(Role role) {
		roles.remove(role);
		role.getAccounts().remove(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Account))
			return false;
		return account_id != null && account_id.equals(((Account) obj).getAccount_id());
	}

	@Override
	public int hashCode() {
		return 23;
	}
}
