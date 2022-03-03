package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository <Visitante, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Visitante find(Integer id);
	
}
