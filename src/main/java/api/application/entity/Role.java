package api.application.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String role_id;
	@NaturalId
	private String role_name;
	@ManyToMany(mappedBy = "roles")
	@JsonBackReference("account_roles_ref")
	private Set<Account> accounts = new HashSet<>();

	public Role(String role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role role = (Role) obj;
		return Objects.equals(role.getRole_name(), role_name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(role_name);
	}
}
