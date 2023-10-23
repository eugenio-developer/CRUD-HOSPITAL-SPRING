package com.saude.eugenio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saude.eugenio.model.Especialidade;
import com.saude.eugenio.service.ServiceEspecialidade;

@Controller
@RequestMapping("/especialidades")
public class ControllerEspecialidade {
	
	@Autowired
	private ServiceEspecialidade serviceEspecialidade;
	
	@GetMapping(value = "/novaespecialidade")
	public String novaEspecialidade(Model model) {
		model.addAttribute("especialidade" , new Especialidade());
		return "especialidades/novaespecialidade";
	}
	@PostMapping(value = "/salvar")
	public String salvarEspecialidade(@ModelAttribute Especialidade especialidade){
		serviceEspecialidade.salvarEspecialidade(especialidade);
		return "redirect:/especialidades";
	}
	@GetMapping(value = "")
	public String listAll(Model model) {
		model.addAttribute("especialidades" , serviceEspecialidade.listaTodos());
		
		return "especialidades/especialidades";
	}
	@GetMapping(value = "/excluir/{codigo}")
	public String excluirEspecialidade(@PathVariable ("codigo") int codigo) {
		Especialidade especialidade = serviceEspecialidade.getEspecialidade(codigo);
		serviceEspecialidade.excluirEspecialidade(especialidade);
		return "redirect:/especialidades";
	}
	@GetMapping(value = "/editar/{codigo}")
	public String editarEspecialidade(@PathVariable ("codigo") int codigo, Model model) {
		Especialidade especialidade = serviceEspecialidade.getEspecialidade(codigo);
		model.addAttribute("especialidade", especialidade);
		return "especialidades/novaespecialidade";
		
	}
	
}
