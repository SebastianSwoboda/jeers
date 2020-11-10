package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.service.PersonService;
import ch.bbc.uek223.jeers.entities.Person;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.NoResultException;

@ManagedBean(name = "user")
@RequestScoped
public class UserBean {
    @EJB
    PersonService personService;

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String login() {
        try {
            Person person = personService.getUser(firstName);
            return "event/event.xhtml";
        } catch (Exception e) {
            return "loginerror.xhtml?faces-redirect=true";
        }
    }
}
