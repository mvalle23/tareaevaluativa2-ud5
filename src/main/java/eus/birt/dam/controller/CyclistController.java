package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.service.CyclistService;

@Controller
@RequestMapping ("/cyclist")
public class CyclistController {

	@Autowired
	CyclistService cyclistService;
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		cyclistService.deleteById(id);
		return "redirect:/cyclists";
	}
}
