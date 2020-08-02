package api.application.entity;

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
public class Admin extends User {
	public Admin(String user_id, String name, String email, String phone, String address, Account account) {
		super(user_id, name, email, phone, address, account);
	}
}
