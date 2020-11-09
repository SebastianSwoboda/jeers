package ch.bbc.uek223.jeers.ejb.service;

import ch.bbc.uek223.jeers.entities.Person;
import ch.bbc.uek223.jeers.entities.Ticket;
import ch.bbc.uek223.jeers.entities.TicketKategorie;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class TicketService {
    @PersistenceContext
    private EntityManager em;

    public void buy(Person buyer, Ticket ticket) {
        ticket.setKaeufer(buyer);
        em.merge(ticket);
        em.flush();
    }

    public void deleteTicket(Long id) {
        Ticket ticket = em.find(Ticket.class, id);
        em.remove(ticket);
        em.flush();
    }

    public Ticket getTicket(Long id) {
        return em.find(Ticket.class, id);

    }

    public void addTicketkategorie(Ticket ticket) {
        em.persist(ticket);
        em.flush();

    }
}
