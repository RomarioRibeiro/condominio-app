package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Cidade find(Integer id);
	
}
