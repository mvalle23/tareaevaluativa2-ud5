package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Cyclist;
import eus.birt.dam.repository.CyclistRepository;
import eus.birt.dam.repository.TeamRepository;

@Controller
@RequestMapping ("/cyclists")
public class CyclistController {

	@Autowired
	CyclistRepository cyclistRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		cyclistRepository.deleteById(id);
		return "redirect:/cyclists";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Cyclist cyclist = new Cyclist();
		model.addAttribute("cyclist", cyclist);
		model.addAttribute("teams", teamRepository.findAll());
		return "cyclistForm";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Cyclist cyclist) {
		cyclistRepository.save(cyclist);
		return "redirect:/cyclists/";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("cyclist", cyclistRepository.findById(id));
		model.addAttribute("teams", teamRepository.findAll());
		return "cyclistForm";
	}
}