/*
package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Libro;
import eus.birt.dam.repository.LibroRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private LibroRepository libroRepository;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		Libro libro1 = new Libro("El Mentiroso", "Mikel Santiago",LocalDate.parse("2020-04-15"));
		libroRepository.save(libro1);
		System.out.println("Started in Bootstrap");
        System.out.println("Number of libros: " + libroRepository.count());
			
	}
	
}*/