package com.github.jadilson22a.TaskProject.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class TarefaDTO {
    private Integer id;
    private String titulo;
    private String descricao;
    private boolean concluido;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) //Transforma o objeto recebido pelo html em LocalDate
    private LocalDate prazo;
    private Prioridade prioridade;

    public TarefaDTO() {
    }

    public TarefaDTO(Integer id, String titulo, String descricao, boolean concluido, LocalDate prazo, Prioridade prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = concluido;
        this.prazo = prazo;
        this.prioridade = prioridade;
    }

    public Tarefa toTarefa() {
        return new Tarefa(titulo, descricao, prazo, prioridade);
    }

    // Getters and Setters
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
