package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Libro;
import eus.birt.dam.repository.LibroRepository;
import eus.birt.dam.repository.EditorialRepository;

@Controller
@RequestMapping ("/libros")
public class LibroController {

	@Autowired
	LibroRepository libroRepository;
	
	@Autowired
	EditorialRepository editorialRepository;
	
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		libroRepository.deleteById(id);
		return "redirect:/libros";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Libro libro = new Libro();
		model.addAttribute("libro", libro);
		model.addAttribute("editoriales", editorialRepository.findAll());
		return "libroForm";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Libro libro) {
		libroRepository.save(libro);
		return "redirect:/libros";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("libro", libroRepository.findById(id));
		model.addAttribute("editorial", editorialRepository.findAll());
		return "libroForm";
	}
}