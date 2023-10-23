package com.saude.eugenio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saude.eugenio.model.Medico;
import com.saude.eugenio.service.ServiceEspecialidade;
import com.saude.eugenio.service.ServiceMedico;

@Controller
@RequestMapping("/medicos")
public class ControllerMedico {
	
	@Autowired
	private ServiceMedico serviceMedico;
	
	@Autowired
	private ServiceEspecialidade serviceEspecialidade;
	
	@GetMapping(value = "/novomedico")
	public String novoMedico(Model model) {
		model.addAttribute("especialidades", serviceEspecialidade.listaTodos());
		model.addAttribute("medico", new Medico());
		return "medicos/novomedico";
	}
	
	@PostMapping(value = "/salvar")
	public String salvarMedico(@ModelAttribute Medico medico) {
		serviceMedico.salvarMedico(medico);
		return "redirect:/medicos";
	}
	@GetMapping(value = "")
	public String listAll(Model model) {
		model.addAttribute("medicos", serviceMedico.listaTodos());
		
		return "medicos/medicos";
	}
	
	@GetMapping(value = "/excluir/{codigo}")
	public String excluirMedico(@PathVariable ("codigo") int codigo) {
		Medico medico = serviceMedico.getMedico(codigo);
		serviceMedico.excluirMedico(medico);
		return"redirect:/medicos";
	}
	@GetMapping(value = "/editar/{codigo}")
	public String editarMedico(@PathVariable ("codigo") int codigo,Model model) {
		Medico medico = serviceMedico.getMedico(codigo);
		model.addAttribute("especialidades", serviceEspecialidade.listaTodos());
		model.addAttribute("medico", medico);
		return "medicos/novomedico";
	}
	
}
