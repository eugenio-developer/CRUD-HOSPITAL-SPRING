package com.saude.eugenio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saude.eugenio.model.Paciente;
import com.saude.eugenio.service.ServicePaciente;

@Controller
@RequestMapping("/pacientes")
public class ControllerPaciente {
	
	@Autowired
	private ServicePaciente servicePaciente;
	
	@GetMapping(value = "/novopaciente")
	private String novoPaciente(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "pacientes/novopaciente";
	}
	
	@PostMapping(value = "/salvar")
	public String salvarPaciente(@ModelAttribute Paciente paciente) {
		servicePaciente.salvarPaciente(paciente);
		return "redirect:/pacientes";
	}
	
	@GetMapping (value = "")
	public String listAll(Model model) {
		model.addAttribute("pacientes", servicePaciente.listaTodos());
		return "pacientes/pacientes";
	}
	
	@GetMapping(value ="/excluir/{codigo}")
	public String excluirPaciente(@PathVariable ("codigo") int codigo) {
		Paciente paciente = servicePaciente.getPaciente(codigo);
		servicePaciente.excluirPaciente(paciente);
		return "redirect:/pacientes";
	}
	@GetMapping(value ="/editar/{codigo}")
	public String editarPaciente(@PathVariable ("codigo") int codigo, Model model) {
		Paciente paciente = servicePaciente.getPaciente(codigo);
		model.addAttribute("paciente", paciente);		
		return "pacientes/novopaciente";
	}
	
}
