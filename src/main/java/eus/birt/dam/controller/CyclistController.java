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

@Controller
@RequestMapping ("/cyclists")
public class CyclistController {

	@Autowired
	CyclistRepository cyclistRepository;
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		cyclistRepository.deleteById(id);
		return "redirect:/cyclists";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Cyclist cyclist = new Cyclist();
		model.addAttribute("cyclist", cyclist);
		return "createCyclistForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Cyclist cyclist) {
		cyclistRepository.save(cyclist);
		return "redirect:/cyclists/";
		}
	}

