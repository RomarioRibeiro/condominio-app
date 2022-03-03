package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Apartamento;

@Repository
public interface ApartamentoRepository extends JpaRepository <Apartamento, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Apartamento find(Integer id);
	
}
