package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="team")
public class Team {
	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",schema="cyclism")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	private String name;
	
	private String city;
	
	private String nationality;
	
	private String director;
	
	@OneToMany
	@JoinColumn (name = "team_id")
	List <Cyclist> cyclists = new ArrayList<>();

	public Team(String name, String city, String nationality, String director) {
		super();
		this.name = name;
		this.city = city;
		this.nationality = nationality;
		this.director = director;
	}
	
	
}
