package org.eagle.security.config;

import org.eagle.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true/*jsr250Enabled=true*//*securedEnabled=true*/)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username)
					throws UsernameNotFoundException {
				return userService.fetch(username);
			}
		}).passwordEncoder(new BCryptPasswordEncoder());
		/*auth.inMemoryAuthentication().withUser("bharat").password("bharat")
				.roles("USER");
		auth.inMemoryAuthentication().withUser("singh").password("singh")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("adhikari").password("adhikari")
				.roles("USER", "ADMIN");*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().anyRequest().permitAll();
		http.authorizeRequests().antMatchers("/login", "/logout").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/hello", true).and()
				.logout().logoutSuccessUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/out"));
		
		http.csrf().disable();
	}
}
