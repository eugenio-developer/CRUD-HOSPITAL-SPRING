package com.saude.eugenio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saude.eugenio.model.Paciente;

@Repository
public interface RepositoryPaciente extends JpaRepository<Paciente, Integer>{

}
