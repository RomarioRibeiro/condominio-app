package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Bloco;

@Repository
public interface BlocoRepository extends JpaRepository <Bloco, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Bloco find(Integer id);
	
}
