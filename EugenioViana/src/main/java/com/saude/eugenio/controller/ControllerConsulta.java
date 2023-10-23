package com.saude.eugenio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saude.eugenio.model.Consulta;
import com.saude.eugenio.service.ServiceConsulta;
import com.saude.eugenio.service.ServiceMedico;
import com.saude.eugenio.service.ServicePaciente;

@Controller
@RequestMapping("/consultas")
public class ControllerConsulta {
	 
	@Autowired
	private ServiceConsulta serviceConsulta;
	
	@Autowired
	private ServiceMedico serviceMedico;
	
	@Autowired
	private ServicePaciente servicePaciente;
	  
	@GetMapping(value = "/novaconsulta")
	public String novaConsulta(Model model) {
		model.addAttribute("medicos", serviceMedico.listaTodos());
		model.addAttribute("pacientes", servicePaciente.listaTodos());
		model.addAttribute("consulta", new Consulta());
		return "consultas/novaconsulta";
	}
	 
	@PostMapping(value = "/salvar")
	public String salvarConsulta(@ModelAttribute Consulta consulta) {
		serviceConsulta.salvarConsulta(consulta);
		return "redirect:/consultas";
	}
	
	@GetMapping(value = "")
	public String listAll(Model model) {
		model.addAttribute("consultas", serviceConsulta.listaTodos());
		return "consultas/consultas";
	}
	
	@GetMapping(value ="/excluir/{codigo}")
	public String excluirConsulta(@PathVariable ("codigo") int codigo) {
		Consulta consulta = serviceConsulta.getConsulta(codigo);
		serviceConsulta.excluirConsulta(consulta);
		return "redirect:/consultas";
	}
	
	@GetMapping(value ="/editar/{codigo}")
	public String editarConsulta(@PathVariable ("codigo") int codigo, Model model) {
		Consulta consulta = serviceConsulta.getConsulta(codigo);
		model.addAttribute("medicos", serviceMedico.listaTodos());
		model.addAttribute("pacientes", servicePaciente.listaTodos());
		model.addAttribute("consulta", consulta);
		return "consultas/novaconsulta";
	}
	
	
	
}
