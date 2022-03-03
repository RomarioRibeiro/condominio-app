package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Apartamento;
import com.romario.condominio.repository.ApartamentoRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class ApartamentoService {

	@Autowired
	private ApartamentoRepository repo; 
	
	
	public Apartamento find(Integer id) {
		Optional<Apartamento> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Apartamento.class));
		
		
	}
	public Apartamento insert (Apartamento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Apartamento update(Apartamento obj) {
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

	public List<Apartamento> findAll() {

		return repo.findAll();
	}

	
}
