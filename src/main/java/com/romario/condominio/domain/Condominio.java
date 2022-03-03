package com.romario.condominio.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Condominio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String cnpj;
	
	@OneToOne
	private Endereco endereco;
	
	
	public Condominio() {
		super();
	}

	public Condominio(Integer id, String cnpj, Endereco endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEmdereco() {
		return endereco;
	}

	public void setEmdereco(Endereco emdereco) {
		this.endereco = emdereco;
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
		Condominio other = (Condominio) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
