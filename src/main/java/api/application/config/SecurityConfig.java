package api.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import api.application.filters.JwtFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService service;
	@Autowired
	private JwtFilter filter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/api/cart/**").authenticated()
				.antMatchers("/api/order/**").authenticated().antMatchers(HttpMethod.GET, "/api/**")
				.permitAll().antMatchers(HttpMethod.POST, "/api/products/**").hasRole("ADMIN").antMatchers("/admin/**")
				.hasRole("ADMIN").and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(getPasswordEncoder());
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
