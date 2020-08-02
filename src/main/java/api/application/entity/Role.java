package api.application.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "role")
public class Role {
	@Id
	private String role_id;
	private String role_name;
	@ManyToMany(mappedBy = "roles")
	private List<Account> accounts;

	public Role(String role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
}
