package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Seguranca;

@Repository
public interface SegurancaRepository extends JpaRepository <Seguranca, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Seguranca find(Integer id);
	
}
