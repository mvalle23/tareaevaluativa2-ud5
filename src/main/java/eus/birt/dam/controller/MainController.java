package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.CyclistRepository;


@Controller
	public class MainController {
	
	@Autowired
   	private CyclistRepository cyclistRepository;
	
	@GetMapping ({"/","/welcome"})
	public String welcome(Model model) {
		model.addAttribute("cyclists", cyclistRepository.findAll());
		return "index";
	}
}
	

