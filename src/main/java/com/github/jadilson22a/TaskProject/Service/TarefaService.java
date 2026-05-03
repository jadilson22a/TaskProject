package com.github.jadilson22a.TaskProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jadilson22a.TaskProject.entities.Tarefa;
import com.github.jadilson22a.TaskProject.entities.TarefaDTO;
import com.github.jadilson22a.TaskProject.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	public TarefaDTO salvar(TarefaDTO dto) {
		Tarefa tarefa = dto.toTarefa();
		Tarefa tarefaSalva = repository.save(tarefa);
		return tarefaSalva.toDTO();
	}
	
	public TarefaDTO atualizar(Integer id, TarefaDTO dto) {
		Tarefa tarefa = dto.toTarefa();
		tarefa.setId(id);
		Tarefa tarefaSalva = repository.save(tarefa);
		return tarefaSalva.toDTO();
	}
	
	public void deletar(Integer id) {
		Optional<Tarefa> buscaTarefa = repository.findById(id);
		
		if(buscaTarefa.isPresent()) {
			repository.delete(buscaTarefa.get());
		}else {
			throw new RuntimeException("Tarefa não encontrada!");
		}
	}

	public TarefaDTO buscarPorId(Integer id) {
		return repository.findById(id)
				.map(Tarefa::toDTO)
				.orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
	}
	
	public List<TarefaDTO> buscarCondicao(boolean concluido){
		List<Tarefa> tarefasEncontradas = repository.findByConcluido(concluido);
		List<TarefaDTO> tarefasDTO = tarefasEncontradas.stream().map(x -> x.toDTO()).toList();
		return tarefasDTO;
	}

	public List<TarefaDTO> buscarTodos(){
		List<Tarefa> tarefasEncontradas = repository.findAll();
		List<TarefaDTO> tarefasDTO = tarefasEncontradas.stream().map(x -> x.toDTO()).toList();
		return tarefasDTO;
	}

	public void concluir(Integer id) {
		Optional<Tarefa> tarefa = repository.findById(id);

		if (tarefa.isPresent()) {
			Tarefa entidade = tarefa.get();
			entidade.setConcluido(true);
			repository.save(entidade);
		} else {
			throw new RuntimeException("Tarefa não encontrada!");
		}
	}
}
