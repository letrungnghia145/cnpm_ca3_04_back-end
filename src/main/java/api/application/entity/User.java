package api.application.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class User {
	@Id
	private String user_id;
	private String name;
	private String email;
	private String phone;
	private String address;
	@OneToOne
	private Account account;

	public User(String user_id, String name, String email, String phone, String address, Account account) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.account = account;
	}
}
