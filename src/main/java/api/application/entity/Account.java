package api.application.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
public class Account {
	@Id
	private String account_id;
	private String username;
	private String password;
	@ManyToMany
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;

	public Account(String username, String password, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
}
