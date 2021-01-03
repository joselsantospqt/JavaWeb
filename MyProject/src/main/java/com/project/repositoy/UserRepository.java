package com.project.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

 
	/* BUSCAR E COMPARAR SENHAS PARA ACESSO A TELA DE LOGIN */
	public User findByUsernameAndPassword(String username, String password);



}
