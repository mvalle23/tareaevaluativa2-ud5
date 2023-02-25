package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Entidad editorial
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="editorial")
public class Editorial {
	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",schema="libreria2")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	private String nombre;
	
	private String ciudad;
	
	private String pais;
	
	private String manager;
	
	
	@OneToMany (mappedBy = "editorial",cascade = CascadeType.ALL)
	List <Libro> libros = new ArrayList<>();

	public Editorial(String nombre, String ciudad, String pais, String manager) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.manager = manager;
	}
	
	
}
