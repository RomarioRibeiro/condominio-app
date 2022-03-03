package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Visitante;
import com.romario.condominio.repository.VisitanteRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class VisitanteService {

	@Autowired
	private VisitanteRepository repo; 
	
	
	public Visitante find(Integer id) {
		Optional<Visitante> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Visitante.class));
		
		
	}
	public Visitante insert (Visitante obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Visitante update(Visitante obj) {
		Visitante newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}
	private void updateData(Visitante newobj, Visitante obj) {
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

	public List<Visitante> findAll() {

		return repo.findAll();
	}

	
}
