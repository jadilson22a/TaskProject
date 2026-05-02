package com.github.jadilson22a.TaskProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jadilson22a.TaskProject.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

	List<Tarefa> findByConcluido(boolean concluido);
}
