package com.project.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.User;
import com.project.service.Criptografar;
import com.project.service.UserService;

import antlr.StringUtils;

@Controller
public class ApplicationController {

	@Autowired
	private UserService userService;

	/* INICIAR O PROJETO */
	@RequestMapping("/")
	public String iniciar() {
		return "login";
	}

	/* DASHBOARD */
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "index";
	}

	/* PÁGINA DE LOGIN */

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "login";
	}

	/* URL PARA LOGAR O USUÁRIO */

	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if (userService.findByUsernameAndPassword(user.getUsername(), Criptografar.encriptografar(user.getPassword())) != null) {
			return "index";
		} else {
			request.setAttribute("error", "Usuário Invalido");
			return "login";

		}
	}

	/* URL PARA A PÁGINA DE CADASTRO */

	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cadastrar";
	}

	/* URL PARA SALVAR O USUÁRIO CHAMA O SERVIÇO "saveUser" */

	@PostMapping("/save-user")
	public String cadastrarUsuario(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveUser(user);
		request.setAttribute("success", "Usuário cadastrado com Sucesso");
		return "cadastrar";
	}

	/* URL PARA A PÁGINA DE BUSCA */
	@RequestMapping("/buscar")
	public String buscar() {
		return "search";
	}

	/* URL PARA BUSCAR TODOS USUÁRIOS */
	@GetMapping("/Show-All-User")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		return "allUser";
	}

	/* EXIBIR UM USUÁRIO */
	@GetMapping("/show-User")
	public String showUsers(@RequestParam String id, HttpServletRequest request) {
		int userID = 0;
		try {
			userID = Integer.parseInt(id);
		} catch (Exception e) {
		}

		User user = userService.showUserByid(userID);

		if (user != null) {
			request.setAttribute("success", "Usuário retornado com sucesso");
			request.setAttribute("user", user);
			return "update";
		} else {
			request.setAttribute("error", "Usuário Não Encontrado");
			return "search";

		}
	}

	/* EDITAR O USUÁRIO */

	@PostMapping("/edit-user")
	public String editUsuario(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveUser(user);
		request.setAttribute("success", "Usuário atualizado com Sucesso");
		return "update";
	}

	/* DELETAR O USUÁRIO */
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		User user = userService.showUserByid(id);
		if (user != null) {
			request.setAttribute("user", user);
			return "deleteUser";
		} else {
			request.setAttribute("error", "Usuário Não Encontrado");
			return "update";
		}

	}

	/* CONFIRMAR A DELETE DO USUÁRIO */
	@RequestMapping("/delete-user-confirm")
	public String deleteUserConfirm(@RequestParam int id, HttpServletRequest request) {
		userService.deleteUser(id);
		request.setAttribute("success", "Usuário apagado com sucesso");
		return "update";
	}

}
