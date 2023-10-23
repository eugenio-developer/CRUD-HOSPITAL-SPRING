package com.saude.eugenio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.eugenio.model.Medico;
import com.saude.eugenio.repository.RepositoryMedico;
@Service
public class ServiceMedico {
 
	@Autowired
	private RepositoryMedico repositoryMedico;
	
	
	public void salvarMedico(Medico medico) {
		repositoryMedico.save(medico);
	}
	public void excluirMedico(Medico medico){
		repositoryMedico.delete(medico);
	}
	public Medico getMedico(int id) {
		return repositoryMedico.findById(id).get();
	}
	public List<Medico> listaTodos(){
		return repositoryMedico.findAll();
	}
		
}
