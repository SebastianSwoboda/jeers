package ch.bbc.uek223.jeers.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name ="TICKET_KATEGORIE")
@NamedQuery(name = "TicketKategorie.findAll", query = "select tk from TicketKategorie tk order by tk.name desc")
public class TicketKategorie extends AbstractBaseEntity {

	@Column(name = "NAME", nullable = false)
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
