package com.github.jadilson22a.TaskProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.jadilson22a.TaskProject.Service.TarefaService;
import com.github.jadilson22a.TaskProject.entities.Prioridade;
import com.github.jadilson22a.TaskProject.entities.TarefaDTO;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService service;
	
	//Controladores de templates
	@GetMapping("/novo")
	public String novoFormulario(Model model) {
		model.addAttribute("tarefaDTO", new TarefaDTO(null, "", "", false,null, Prioridade.BAIXA));
		model.addAttribute("formAction", "/tarefas/salvar");
		model.addAttribute("formTitle", "Cadastrar nova tarefa");
		return "tarefa-form";
	}
	
	@GetMapping()
	public String buscarTodos(Model model){
		List<TarefaDTO> tarefas = service.buscarCondicao(false);
		model.addAttribute("tarefas", tarefas);
		return "tarefas";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		TarefaDTO tarefaDTO = service.buscarPorId(id);
		model.addAttribute("tarefaDTO", tarefaDTO);
		model.addAttribute("formAction", "/tarefas/atualizar");
		model.addAttribute("formTitle", "Atualizar tarefa");
		return "tarefa-form";
	}
	
	//Controladores de ações
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute TarefaDTO dto) {
		service.salvar(dto);
		return "redirect:/tarefas";
	}

	@PostMapping("/concluir")
	public String concluir(@RequestParam Integer id) {
		service.concluir(id);
		return "redirect:/tarefas";
	}

	@PostMapping("/atualizar")
	public String atualizar(@ModelAttribute TarefaDTO dto) {
		service.atualizar(dto.getId(), dto);
		return "redirect:/tarefas";
	}
}
