package eus.birt.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CyclistController {

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		cyclistService.delete(id);
		return "redirect:/cyclists";
	}
}
