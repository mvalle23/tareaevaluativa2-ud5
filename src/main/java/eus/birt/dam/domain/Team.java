package eus.birt.dam.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Data /*Lombok crea los getters y setters...*/
@Entity
@Table(name="team")
public class Team {
	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe",schema="cyclism")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	private String name;
	
	private String city;
	
	private String nationality;
	
	private String director;

	public Team(String name, String city, String nationality, String director) {
		super();
		this.name = name;
		this.city = city;
		this.nationality = nationality;
		this.director = director;
	}
	
	
}
