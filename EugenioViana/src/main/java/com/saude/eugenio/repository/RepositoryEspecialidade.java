package com.saude.eugenio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saude.eugenio.model.Especialidade;

@Repository
public interface RepositoryEspecialidade extends JpaRepository<Especialidade, Integer>{

}
