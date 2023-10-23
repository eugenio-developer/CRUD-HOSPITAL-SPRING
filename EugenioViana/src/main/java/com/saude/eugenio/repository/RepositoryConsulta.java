package com.saude.eugenio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saude.eugenio.model.Consulta;

@Repository
public interface RepositoryConsulta extends JpaRepository<Consulta, Integer>{
	
}
