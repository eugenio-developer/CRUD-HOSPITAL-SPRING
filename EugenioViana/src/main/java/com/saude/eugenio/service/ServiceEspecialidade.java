package com.saude.eugenio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.eugenio.model.Especialidade;
import com.saude.eugenio.repository.RepositoryEspecialidade;

@Service
public class ServiceEspecialidade {
	@Autowired
	private RepositoryEspecialidade repositoryespecialidade;
	
	public void salvarEspecialidade(Especialidade especialidade) {
		repositoryespecialidade.save(especialidade);
	}
	public void excluirEspecialidade(Especialidade especialidade) {
		repositoryespecialidade.delete(especialidade);
	}
	public List<Especialidade> listaTodos(){
		return repositoryespecialidade.findAll();
	}
	public Especialidade getEspecialidade(int id) {
		return repositoryespecialidade.findById(id).get();
	}
	
}
