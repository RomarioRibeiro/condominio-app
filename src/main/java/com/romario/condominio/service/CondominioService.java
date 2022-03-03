package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Condominio;
import com.romario.condominio.repository.CondominioRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository repo; 
	
	
	public Condominio find(Integer id) {
		Optional<Condominio> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Condominio.class));
		
		
	}
	public Condominio insert (Condominio obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Condominio update(Condominio obj) {
		Condominio newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}
	private void updateData(Condominio newobj, Condominio obj) {
		newobj.setCnpj(obj.getCnpj());
		
	}
	public void delete(Integer id) {
		find(id);
		try {

			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatallntegrityException("Não e possivel excluir uma categoria que possui produtos");
		}

	}

	public List<Condominio> findAll() {

		return repo.findAll();
	}

	
}
