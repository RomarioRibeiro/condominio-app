package com.romario.condominio.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Apartamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	@OneToOne
	private Bloco bloco;
	
	public Apartamento() {
		super();
	}

	public Apartamento(Integer id, String numero, Bloco bloco) {
		super();
		this.id = id;
		this.numero = numero;
		this.bloco = bloco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
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
		Apartamento other = (Apartamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
