package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Endereco;
import com.romario.condominio.repository.EnderecoRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo; 
	
	
	public Endereco find(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Endereco.class));
		
		
	}
	public Endereco insert (Endereco obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Endereco update(Endereco obj) {
		 find(obj.getId());
		return repo.save(obj);
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {

			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatallntegrityException("Não e possivel excluir uma categoria que possui produtos");
		}

	}

	public List<Endereco> findAll() {

		return repo.findAll();
	}

	
}
