package com.github.jadilson22a.TaskProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.jadilson22a.TaskProject.Service.TarefaService;
import com.github.jadilson22a.TaskProject.entities.TarefaDTO;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService service;
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute TarefaDTO dto) {
		service.salvar(dto);
		return "redirect:/tarefa";
	}
	
	
}
