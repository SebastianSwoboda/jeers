package ch.bbc.uek223.openair.entitytest;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ch.bbc.uek223.jeers.entities.Event;
import ch.bbc.uek223.jeers.entities.Person;
import ch.bbc.uek223.jeers.entities.Rolle;
import ch.bbc.uek223.jeers.entities.Ticket;
import ch.bbc.uek223.jeers.entities.TicketKategorie;

public class NamedQueriesTest extends EntityManagerTest {

	@Test
	public void testTicketKategorie() {
		List<TicketKategorie> resultList = em.createNamedQuery("TicketKategorie.findAll", TicketKategorie.class)
				.getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals("Stehplatz", resultList.get(0).getName());
	}

	@Test
	public void testEvent() {
		List<Event> resultList = em.createNamedQuery("Event.findAll", Event.class).getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals("Gurtenfestival", resultList.get(0).getName());
	}

	@Test
	public void testUnverkaufteTickets() {
		Event e = em.find(Event.class, 1L);

		List<Ticket> resultList = em.createNamedQuery("Ticket.findUnsold", Ticket.class).setParameter("event", e)
				.getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals(new BigDecimal(150), resultList.get(0).getPreis());
	}

	@Test
	public void testUnverkaufteTicketsProKategorie() {
		Event e = em.find(Event.class, 1L);
		TicketKategorie tk = em.find(TicketKategorie.class, 1L);
		
		List<Ticket> resultList = em.createNamedQuery("Ticket.findUnsoldPerCategory", Ticket.class)
				.setParameter("event", e)
				.setParameter("ticketKategorie", tk)				
				.getResultList();

		Assert.assertEquals(1, resultList.size());
		Assert.assertEquals(new BigDecimal(150), resultList.get(0).getPreis());
	}
	
	@Test
	public void testTotalUnverkaufteTickets() {
		Event e = em.find(Event.class, 1L);
		
		Long resultat = em.createNamedQuery("Ticket.findTotalUnsoldPerEvent", Long.class)
				.setParameter("event", e)
				.getSingleResult();

		Assert.assertEquals(new Long(1), resultat);
	}
	
	@Test
	public void testAnzahlUnverkaufteTickets() {
		
		List<Object[]> resultat = em.createNamedQuery("Ticket.findUnsoldAmount", Object[].class)
				.getResultList();

		Assert.assertEquals(1, resultat.size());
		Assert.assertEquals(1L, resultat.get(0)[0]);
		Assert.assertTrue(resultat.get(0)[1] instanceof Event);
		Assert.assertEquals("Gurtenfestival", ((Event) resultat.get(0)[1]).getName());
	}
	
	@Test
	public void testPerson() {
		List<Person> resultList = em.createNamedQuery("Person.findAll", Person.class).getResultList();

		Assert.assertEquals(2, resultList.size());
		Assert.assertEquals("Admin", resultList.get(0).getName());
		Assert.assertEquals("User", resultList.get(1).getName());
	}
	
	@Test
	public void testRolleProPerson() {
		List<Rolle> resultList = em.createNamedQuery("Rolle.findByPerson", Rolle.class)
				.setParameter("person", em.getReference(Person.class, 1L))
				.getResultList();

		Assert.assertEquals(2, resultList.size());
		Assert.assertEquals("admin", resultList.get(0).getName());
		Assert.assertEquals("user", resultList.get(1).getName());
	}
}
