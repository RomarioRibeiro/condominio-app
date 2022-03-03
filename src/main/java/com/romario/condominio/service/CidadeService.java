package com.romario.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.romario.condominio.domain.Cidade;
import com.romario.condominio.repository.CidadeRepository;
import com.romario.condominio.service.exception.DatallntegrityException;
import com.romario.condominio.service.exception.ObjectNotFoundexception;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo; 
	
	
	public Cidade find(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundexception("Obejeto não encontrado: ID: " + id + ", Tipo" + Cidade.class));
		
		
	}
	public Cidade insert (Cidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Cidade update(Cidade obj) {
		Cidade newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}
	private void updateData(Cidade newobj, Cidade obj) {
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

	public List<Cidade> findAll() {

		return repo.findAll();
	}

	
}
