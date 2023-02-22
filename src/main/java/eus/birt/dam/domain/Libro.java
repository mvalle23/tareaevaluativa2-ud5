package eus.birt.dam.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libro")
public class Libro {
	@Id
	@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe",schema="libreria2")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen")
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="genero")
	private String genero;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fechapublicacion;

	
	@ManyToOne
	@JoinColumn (name = "editorial_id")
	private Editorial editorial;

	public Libro(String titulo,String autor, String genero, LocalDate fechapublicacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.fechapublicacion = fechapublicacion;
		//this.nationality = nationality;
	}
}
