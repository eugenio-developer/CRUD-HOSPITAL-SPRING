package com.saude.eugenio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

 
@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private Integer cmr;
	@ManyToOne
	@JoinColumn(name="especialidade_id" ,nullable = false)
	private Especialidade especialidade;
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;
	
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCmr() {
		return cmr;
	}
	public void setCmr(Integer cmr) {
		this.cmr = cmr;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
