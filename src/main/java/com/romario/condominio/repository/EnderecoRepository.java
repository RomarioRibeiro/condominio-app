package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Endereco find(Integer id);
	
}
