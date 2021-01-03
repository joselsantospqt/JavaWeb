package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import com.project.model.User;
import com.project.repositoy.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	/* SERVIÇO PARA SALVAR O USUARIO NO BANCO */
	
	public User saveUser(User user) {
		user.setPassword(Criptografar.encriptografar(user.getPassword()));
		return userRepository.save(user);

	}
	
	/* SERVIÇO PARA TRAZER TODOS CADASTRADOS DO BANCO */

	public List<User> showAllUsers() {
		List<User> users = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			users.add(user);
		}

		return users;
	}

	/* SERVIÇO PARA TRAZER UM CADASTRADADO POR ID */
	public User showUserByid(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return user.get();
		return null;
	}
	
	/* SERVIÇO PARA DELETAR UM USUARIO POR ID */

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	/* SERVIÇO PARA BUSCAR E COMPARAR SENHAS PARA ACESSO A TELA DE LOGIN */

	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	
	
	/* CONFIGURAÇÕES DA API */
	
	
	public User buscaPorId(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			return user.get();
		return null;
	}
	
	/* CONFIGURAÇÕES SE EXISTE O USUÁRIO*/
	
	public boolean existy(User user) {
		return userRepository.existsById(user.getId());

	}
	
	

}
