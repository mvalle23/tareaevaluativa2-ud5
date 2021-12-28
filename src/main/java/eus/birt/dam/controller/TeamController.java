package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Team;
import eus.birt.dam.repository.TeamRepository;

@Controller
@RequestMapping ("/teams")
public class TeamController {

@Autowired
TeamRepository teamRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		teamRepository.deleteById(id);
	return "redirect:/teams";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Team team = new Team();
		model.addAttribute("team", team);
		return "teamForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Team team) {
		teamRepository.save(team);
		return "redirect:/teams/";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("team", teamRepository.findById(id));
		return "teamForm";
	}
}
