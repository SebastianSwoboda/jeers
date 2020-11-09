package ch.bbc.uek223.jeers.ejb.service;

import ch.bbc.uek223.jeers.entities.Person;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.xml.registry.infomodel.User;

@LocalBean
@Stateless
public class PersonService {
    @PersistenceContext
    private EntityManager em;

    public void addUser(Person person) {
        em.persist(person);
        em.flush();

    }

    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
        em.flush();

    }

    public void modifyUser(Person person) {
        em.merge(person);
        em.flush();


    }
}
