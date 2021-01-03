package com.project.wsrestful;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.model.User;
import com.project.repositoy.UserRepository;
import com.project.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	public UserRestController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		
		if (userService.existy(user))  {

			System.out.println("A User with name " + user.getNome() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		} else{
			User newUser = userService.saveUser(user);
			System.out.println("Posso inserir");
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder
					.path("/cadastrar/user/{username}/{nome}/{sobrenome}/{email}/{password}").buildAndExpand(newUser.getUsername(), newUser.getNome(),
							newUser.getSobrenome(), newUser.getEmail(), newUser.getPassword())
					.toUri());
			System.out.println("Usuário Cadastrado");
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}
	
	/*
	 * ----------------- JASON CREATE: ---------------
	 * 
	 * { "username" : "teste", "nome" : "aaa", "sobrenome" : "bbb", "email" :
	 * "aaa@aa", "password" : "aaaa"
	 * 
	 * }
	 */

	@GetMapping(value = "/buscaPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> buscaPorId(@PathVariable("id") int id) {

		User user = userService.buscaPorId(id);

		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
	}
}
