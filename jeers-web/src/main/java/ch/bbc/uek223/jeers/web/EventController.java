package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.service.EventService;
import ch.bbc.uek223.jeers.entities.Event;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import org.primefaces.model.SelectableDataModel;

@ManagedBean(name = "eventController")
@ViewScoped
public class EventController implements Serializable {
    @EJB
    EventService eventService;

    private String eventName;

    private List<Event> events;

    private Event selectedEvent;

    @PostConstruct
    public void init() {
        this.events = eventService.getEvents();
    }

    public String getEventName() {
        return eventName;
    }


    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }


    public void addEvent() {
        Event event = new Event();
        event.setName(this.eventName);
        eventService.addEvent(event);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Event added"));
    }

    public void onRowEdit(RowEditEvent event) {
        Event editedEvent = (Event) event.getObject();
        eventService.modifyEvent(editedEvent);
        FacesMessage msg = new FacesMessage("Event Edited", editedEvent.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void deleteEvent() {
        eventService.deleteEvent(selectedEvent.getId());
        FacesMessage msg = new FacesMessage("Event Deleted", selectedEvent.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


}
