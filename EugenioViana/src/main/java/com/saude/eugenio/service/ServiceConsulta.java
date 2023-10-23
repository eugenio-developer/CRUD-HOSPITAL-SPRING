package com.saude.eugenio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saude.eugenio.model.Consulta;
import com.saude.eugenio.repository.RepositoryConsulta;

@Service
public class ServiceConsulta {

	@Autowired
	private RepositoryConsulta repositoryConsulta;
	
	public void salvarConsulta(Consulta consulta) {
		repositoryConsulta.save(consulta);
	}
	public void excluirConsulta(Consulta consulta) {
		repositoryConsulta.delete(consulta);
	}
	public Consulta getConsulta(int codigo) {
		return repositoryConsulta.findById(codigo).get();
	}
	public List<Consulta> listaTodos(){
		return repositoryConsulta.findAll();
	}
	
}
