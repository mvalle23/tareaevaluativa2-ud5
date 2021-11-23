package eus.birt.dam.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="cyclist")
public class Cyclist {
	@Id
	@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe",schema="cyclism")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private LocalDate birthdate;
	
	private String nationality;
	
	@ManyToOne
	@JoinColumn (name = "team_id")
	private Team team;

	public Cyclist(String firstName, String lastName, LocalDate birthdate, String nationality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.nationality = nationality;
	}
}
