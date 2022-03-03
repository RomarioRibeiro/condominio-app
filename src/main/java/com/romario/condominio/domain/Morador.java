package com.romario.condominio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class Morador implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date dataNasc;
	private String cpf;

	@OneToOne
	private Apartamento apartamento;
	
	@ManyToMany(mappedBy = "moradores")
	private List<Visitante> list = new ArrayList<>();
	
	
	@ElementCollection
	@CollectionTable(name= "Telefone")
	private Set<String> telefones = new HashSet<>();
	
	public Morador() {
		super();
	}

	public Morador(Integer id, String nome, Date dataNasc, String cpf, Apartamento apartamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.apartamento = apartamento;
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
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
		Morador other = (Morador) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
