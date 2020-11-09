package ch.bbc.uek223.jeers.ejb.service;

import ch.bbc.uek223.jeers.entities.TicketKategorie;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class TicketkategorieService {
    @PersistenceContext

    private EntityManager em;

    public void addTicketkategorie(TicketKategorie ticketKategorie) {
        em.persist(ticketKategorie);
        em.flush();

    }

    public void deleteTicketkategorie(Long id) {
        TicketKategorie ticketKategorie = em.find(TicketKategorie.class, id);
        em.remove(ticketKategorie);
        em.flush();

    }

    public void modifyTicketkategorie(TicketKategorie ticketKategorie) {
        em.merge(ticketKategorie);
        em.flush();

    }
}
