package ch.bbc.uek223.jeers.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
@NamedQueries({
		@NamedQuery(name = "Ticket.findUnsold", query = "select t from Ticket t where t.kaeufer is null and t.event = :event order by t.preis desc"),
		@NamedQuery(name = "Ticket.findUnsoldPerCategory", query = "select t from Ticket t where t.kaeufer is null and t.event = :event and t.ticketKategorie = :ticketKategorie order by t.preis desc") ,
		@NamedQuery(name = "Ticket.findTotalUnsoldPerEvent", query = "select count(t) from Ticket t where t.kaeufer is null and t.event = :event"),
		@NamedQuery(name = "Ticket.findUnsoldAmount", query = "select count(t), t.event from Ticket t where t.kaeufer is null group by t.event order by count(t) desc")
})
public class Ticket extends AbstractBaseEntity {

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "TICKET_KATEGORIE_FK", nullable = false)
	private TicketKategorie ticketKategorie;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "EVENT_FK", nullable = false)
	private Event event;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "VERKAEUFER_FK", nullable = false)
	private Person verkauefer;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "KAEUFER_FK")
	private Person kaeufer;

	@Column(name = "PREIS", nullable = false)
	private BigDecimal preis;

	public TicketKategorie getTicketKategorie() {
		return ticketKategorie;
	}

	public void setTicketKategorie(TicketKategorie ticketKategorie) {
		this.ticketKategorie = ticketKategorie;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Person getVerkauefer() {
		return verkauefer;
	}

	public void setVerkauefer(Person verkauefer) {
		this.verkauefer = verkauefer;
	}

	public Person getKaeufer() {
		return kaeufer;
	}

	public void setKaeufer(Person kaeufer) {
		this.kaeufer = kaeufer;
	}

	public BigDecimal getPreis() {
		return preis;
	}

	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}

}
