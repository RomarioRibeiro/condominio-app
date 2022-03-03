package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Bloco;
import com.romario.condominio.repository.BlocoRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class BlocoService {

	@Autowired
	private BlocoRepository repo; 
	
	
	public Bloco find(Integer id) {
		Optional<Bloco> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Bloco.class));
		
		
	}
	public Bloco insert (Bloco obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Bloco update(Bloco obj) {
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

	public List<Bloco> findAll() {

		return repo.findAll();
	}

	
}
