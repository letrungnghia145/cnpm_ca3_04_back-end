package api.application.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import api.application.entity.Account;
import api.application.entity.Role;
import api.application.entity.User;
import api.application.repository.AccountRepository;
import api.application.repository.Repository;
import api.application.repository.UserRepository;

@org.springframework.stereotype.Service("user_service")
public class UserService implements UserDetailsService, Service<User> {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("account_repository")
	private Repository account_repository;
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("user_repository")
	private Repository user_repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountRepository repository = (AccountRepository) this.account_repository;
		Account account;
		try {
			account = repository.findAccountByUsername(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (Role role : account.getRoles()) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole_name());
			authorities.add(authority);
		}
		return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(),
				authorities);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User add(User user) throws Exception {
		try {
			Object create = user_repository.create(user);
			return (User) create;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() throws Exception {
		return user_repository.getAll();
	}

	public User getInfomationByUsername(String username) throws Exception {
		User user = null;
		try {
			if (user_repository instanceof UserRepository) {
				UserRepository repository = (UserRepository) user_repository;
				user = repository.getUserByUsername(username);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public User get(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(String id, User entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
