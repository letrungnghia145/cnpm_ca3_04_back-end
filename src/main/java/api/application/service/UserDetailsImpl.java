package api.application.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import api.application.entity.Account;
import api.application.entity.Role;
import api.application.repository.AccountRepository;
import api.application.repository.Repository;

@Service
public class UserDetailsImpl implements UserDetailsService {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("account")
	private Repository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountRepository repository = (AccountRepository) this.repository;
		Account account = repository.findAccountByUsername(username);
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (Role role : account.getRoles()) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole_name());
			authorities.add(authority);
		}
		return new User(account.getUsername(), account.getPassword(), authorities);
	}
}
