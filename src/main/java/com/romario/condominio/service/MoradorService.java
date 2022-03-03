package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Morador;
import com.romario.condominio.repository.MoradorRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class MoradorService {

	@Autowired
	private MoradorRepository repo; 
	
	
	public Morador find(Integer id) {
		Optional<Morador> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Morador.class));
		
		
	}
	public Morador insert (Morador obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Morador update(Morador obj) {
		Morador newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}
	private void updateData(Morador newobj, Morador obj) {
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

	public List<Morador> findAll() {

		return repo.findAll();
	}

	
}
