package com.romario.condominio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Visitante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id ;
	private String nome;
	private String cpf;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = " VISITANTES_MORADOR" , 
	joinColumns =  @JoinColumn( name = "visitante_id"),
	inverseJoinColumns = @JoinColumn(name = "morador_id")
	)
	private List<Morador> moradores = new ArrayList<>();
	
	public Visitante() {
		super();
	}

	public Visitante(Integer id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitante other = (Visitante) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
