package eus.birt.dam.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String initCreationForm(Map<String, Object> model) {
		Cyclist owner = new Cyclist();
		model.put("cyclist", owner);
		return "createCyclistForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@Validated Cyclist cyclist, BindingResult result) {
		if (result.hasErrors()) {
			return "createCyclistForm";
		}
		else {
			this.cyclistRepository.save(cyclist);
			return "redirect:/cyclists/";
		}
	}
}
