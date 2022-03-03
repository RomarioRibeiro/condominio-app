package com.romario.condominio.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Seguranca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome ;
	private Date datNasc;
	private String cpf;
	
	public Seguranca() {
		super();
	}

	public Seguranca(Integer id, String nome, Date datNasc, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.datNasc = datNasc;
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

	public Date getDatNasc() {
		return datNasc;
	}

	public void setDatNasc(Date datNasc) {
		this.datNasc = datNasc;
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
		Seguranca other = (Seguranca) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
