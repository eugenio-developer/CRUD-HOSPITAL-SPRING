package com.saude.eugenio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saude.eugenio.model.Medico;

@Repository
public interface RepositoryMedico extends JpaRepository<Medico, Integer> {

}
