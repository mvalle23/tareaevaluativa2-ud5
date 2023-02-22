package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Editorial;
import eus.birt.dam.repository.EditorialRepository;

@Controller
@RequestMapping ("/editoriales")
public class EditorialController {

@Autowired
EditorialRepository editorialRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		editorialRepository.deleteById(id);
	return "redirect:/editoriales";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Editorial editorial = new Editorial();
		model.addAttribute("editorial", editorial);
		return "editorialForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Editorial editorial) {
		editorialRepository.save(editorial);
		return "redirect:/editoriales";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("editorial", editorialRepository.findById(id));
		return "editorialForm";
	}
}
