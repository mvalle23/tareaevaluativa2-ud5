package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
