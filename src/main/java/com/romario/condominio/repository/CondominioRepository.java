package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository <Condominio, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Condominio find(Integer id);
	
}
