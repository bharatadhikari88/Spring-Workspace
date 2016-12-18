package org.eagle.security.repository;

import org.eagle.security.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
