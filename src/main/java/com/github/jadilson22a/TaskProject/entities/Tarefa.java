package com.github.jadilson22a.TaskProject.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefas")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "concluido")
	private boolean concluido = false;

	@Column(name = "prazo")
	private LocalDate prazo;

	@Column(name = "prioridade")
	private Prioridade prioridade;

	public Tarefa() {
	}

	public Tarefa(String titulo, String descricao, LocalDate prazo, Prioridade prioridade) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prazo = prazo;
		this.prioridade = prioridade;
	}
	
	public TarefaDTO toDTO() {
		return new TarefaDTO(this.id, this.titulo, this.descricao, this.concluido, this.prazo, this.prioridade);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public LocalDate getPrazo() {
		return prazo;
	}

	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	
}
