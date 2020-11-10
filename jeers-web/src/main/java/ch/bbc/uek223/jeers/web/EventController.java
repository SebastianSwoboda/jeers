package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.service.EventService;
import ch.bbc.uek223.jeers.entities.Event;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "event")
@RequestScoped
public class EventController {
    @EJB
    EventService eventService;


    private String eventName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void addEvent(){
        Event event = new Event();
        event.setName(this.eventName);
        eventService.addEvent(event);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Event added"));
    }


}
