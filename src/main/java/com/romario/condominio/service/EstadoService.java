package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Estado;
import com.romario.condominio.repository.EstadoRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo; 
	
	
	public Estado find(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Estado.class));
		
		
	}
	public Estado insert (Estado obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Estado update(Estado obj) {
		Estado newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}
	private void updateData(Estado newobj, Estado obj) {
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

	public List<Estado> findAll() {

		return repo.findAll();
	}

	
}
