package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Seguranca;
import com.romario.condominio.repository.SegurancaRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class SegurancaService {

	@Autowired
	private SegurancaRepository repo; 
	
	
	public Seguranca find(Integer id) {
		Optional<Seguranca> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Seguranca.class));
		
		
	}
	public Seguranca insert (Seguranca obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Seguranca update(Seguranca obj) {
		Seguranca newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}
	private void updateData(Seguranca newobj, Seguranca obj) {
		newobj.setNome(obj.getNome());
		
	}
	public void delete(Integer id) {
		find(id);
		try {

			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatallntegrityException("Não e possivel excluir uma categoria que possui produtos");
		}

	}

	public List<Seguranca> findAll() {

		return repo.findAll();
	}

	
}
