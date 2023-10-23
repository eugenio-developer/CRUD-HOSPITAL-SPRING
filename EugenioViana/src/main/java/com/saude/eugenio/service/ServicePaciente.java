package com.saude.eugenio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.eugenio.model.Paciente;
import com.saude.eugenio.repository.RepositoryPaciente;

@Service
public class ServicePaciente {

	@Autowired
	private RepositoryPaciente repositoryPaciente;
	
	public void salvarPaciente(Paciente paciente) {
		repositoryPaciente.save(paciente);
	}
	public void excluirPaciente(Paciente paciente) {
		repositoryPaciente.delete(paciente);
	}
	public Paciente getPaciente(int codigo) {
		return repositoryPaciente.findById(codigo).get();
	}
	public List<Paciente> listaTodos(){
		return repositoryPaciente.findAll();
	}
}
