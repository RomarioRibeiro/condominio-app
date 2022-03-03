package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Estado find(Integer id);
	
}
