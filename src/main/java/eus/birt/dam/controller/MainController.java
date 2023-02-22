package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.LibroRepository;
import eus.birt.dam.repository.EditorialRepository;


@Controller
	public class MainController {
	
	@Autowired
   	private LibroRepository libroRepository;
	@Autowired
   	private EditorialRepository editorialRepository;
	
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/libros"})
	public String getCyclists(Model model) {
		model.addAttribute("libros", libroRepository.findAll());
		return "libros";
	}
	
	@GetMapping ({"/editoriales"})
	public String getTeams(Model model) {
		model.addAttribute("editoriales", editorialRepository.findAll());
		return "editoriales";
	}
}
	

