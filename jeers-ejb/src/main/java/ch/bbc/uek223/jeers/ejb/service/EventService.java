package ch.bbc.uek223.jeers.ejb.service;

import ch.bbc.uek223.jeers.entities.Event;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class EventService {
    @PersistenceContext
    private EntityManager em;

    public void addEvent(Event event) {
        em.persist(event);
        em.flush();
    }

    public void deleteEvent(Long id) {
        Event event = em.find(Event.class, id);
        em.remove(event);
        em.flush();

    }

    public void modifyEvent(Event event) {
        em.merge(event);
        em.flush();
    }


}
