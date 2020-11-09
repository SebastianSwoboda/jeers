package ch.bbc.uek223.jeers.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLE")

public class Rolle extends AbstractBaseEntity {

	@Column(name = "NAME", nullable = false)
	private String name;

	// Rückbeziehung
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "rolle")
	private List<PersonRolle> personRolle = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PersonRolle> getPersonRolle() {
		return personRolle;
	}

	public void setPersonRolle(List<PersonRolle> personRolle) {
		this.personRolle = personRolle;
	}

}
