package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.CyclistRepository;
import eus.birt.dam.repository.TeamRepository;


@Controller
	public class MainController {
	
	@Autowired
   	private CyclistRepository cyclistRepository;
	@Autowired
   	private TeamRepository teamRepository;
	
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/cyclists"})
	public String getCyclists(Model model) {
		model.addAttribute("cyclists", cyclistRepository.findAll());
		return "cyclists";
	}
	
	@GetMapping ({"/teams"})
	public String getTeams(Model model) {
		model.addAttribute("teams", teamRepository.findAll());
		return "teams";
	}
}
	

