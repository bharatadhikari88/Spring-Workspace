package org.eagle.security.service;

import org.eagle.security.entity.User;
import org.eagle.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public User save(String username,String password,String role){
		return userRepository.save(new User(username,encoder.encode(password),role));
	}
	
	public User fetch(String username){
		return userRepository.findByUsername(username);
	}

}
