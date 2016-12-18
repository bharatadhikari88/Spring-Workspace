package org.eagle.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eagle.security.entity.User;
import org.eagle.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@Autowired
	private UserService userService;

	// @Secured("ROLE_ADMIN") /** old way not support spring expression language
	// @RolesAllowed("ROLE_USER") /** same as "@Secured" only diff it come from
	// java specification **/
	@PreAuthorize("hasRole('ADMIN') AND hasRole('USER')")
	/** support spring expression lang. **/
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String hello(HttpServletRequest  request,HttpServletResponse response) {
		return "hello";
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "logout";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/save/{username}/{password}/{role}", method = RequestMethod.GET)
	public User save(@PathVariable String username,
			@PathVariable String password, @PathVariable String role) {
		return userService.save(username, password, role);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
	@PostAuthorize("hasRole('ROLE_ADMIN') OR returnObject.id == 2")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN') OR hasAuthority('ROLE_USER')") /** Authority need prefix ROLE_ **/
	@RequestMapping(path = "/fetch/{username}", method = RequestMethod.GET)
	public User fetch(@PathVariable String username) {
		return userService.fetch(username);
	}
}
