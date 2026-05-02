package com.github.jadilson22a.TaskProject.entities;

public record TarefaDTO(Integer id, String titulo, String descricao, boolean concluido) {

	public Tarefa toTarefa() {
		return new Tarefa(titulo, descricao);
	}
}
