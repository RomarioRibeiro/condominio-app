package com.romario.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romario.condominio.domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository <Administrador, Integer> {
	@Query(value="select*from categoria where id = ?",nativeQuery = true )
	Administrador find(Integer id);
	
}
