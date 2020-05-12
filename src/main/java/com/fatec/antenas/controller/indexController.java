package com.fatec.antenas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("/")
	private String index() {
		return "index";
	}
	
	@RequestMapping("/empresa/painel")
	public String empresarioView(@RequestAttribute("idUsuarioLogado") String idUsuarioLogado) {
		return "empresa";
	}
}
