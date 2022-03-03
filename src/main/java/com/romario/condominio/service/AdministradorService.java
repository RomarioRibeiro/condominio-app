package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Administrador;
import com.romario.condominio.repository.AdministradorRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repo; 
	
	
	public Administrador find(Integer id) {
		Optional<Administrador> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Administrador.class));
		
		
	}
	public Administrador insert (Administrador obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Administrador update(Administrador obj) {
		Administrador newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}
	private void updateData(Administrador newobj, Administrador obj) {
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

	public List<Administrador> findAll() {

		return repo.findAll();
	}

	
}
