package com.github.jadilson22a.TaskProject.entities;

import java.time.LocalDate;

public record TarefaDTO(Integer id, String titulo, String descricao, boolean concluido, LocalDate prazo) {

	public Tarefa toTarefa() {
		return new Tarefa(titulo, descricao, prazo);
	}
}
