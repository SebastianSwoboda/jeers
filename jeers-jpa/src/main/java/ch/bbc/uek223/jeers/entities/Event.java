package ch.bbc.uek223.jeers.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name ="EVENT")
@NamedQueries(
		{ @NamedQuery(name = "Event.findAll", query = "select e from Event e order by e.name") }
		)
public class Event extends AbstractBaseEntity {

	@Column(name = "NAME", nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
