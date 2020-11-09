package ch.bbc.uek223.jeers.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_ROLLE")
@NamedQueries({ @NamedQuery(name = "Rolle.findByPerson", query = "select pr.rolle from PersonRolle pr where pr.person = :person order by pr.rolle.name") })
public class PersonRolle extends AbstractBaseEntity {

	// Owner der Beziehung
	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "PERSON_FK")
	private Person person;

	// Owner der Beziehung
	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ROLLE_FK")
	private Rolle rolle;

	public Rolle getRolle() {
		return rolle;
	}

	public void setRolle(Rolle rolle) {
		this.rolle = rolle;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
