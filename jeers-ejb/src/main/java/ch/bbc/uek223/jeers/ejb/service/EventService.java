package ch.bbc.uek223.jeers.ejb.service;

import ch.bbc.uek223.jeers.entities.Event;
import ch.bbc.uek223.jeers.entities.Person;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<Event> getEvents() {
        return em.createNamedQuery("Event.findAll", Event.class).getResultList();
    }



}
