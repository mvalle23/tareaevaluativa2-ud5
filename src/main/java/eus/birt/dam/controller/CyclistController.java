package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import eus.birt.dam.service.CyclistService;

@Controller
public class CyclistController {

	@Autowired
	CyclistService cyclistService;
	
	
	@GetMapping("/cyclist/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		
		cyclistService.deleteById(id);
		return "redirect:/cyclists";
	}
}
