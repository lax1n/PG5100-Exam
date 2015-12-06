package no.nith.pg5100.controller;

import no.nith.pg5100.dto.Event;
import no.nith.pg5100.dto.EventType;
import no.nith.pg5100.dto.Subject;
import no.nith.pg5100.infrastructure.event.EventDao;
import no.nith.pg5100.infrastructure.subject.SubjectDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by August on 12/3/2015.
 */
@Model
public class EventController {

    @Inject
    private EventDao eventDao;

    @Inject
    private SubjectDao subjectDao;

    private int eventId;
    private Event event;

    private int subjectId;
    private Subject subject;

    @PostConstruct
    public void init() { event = new Event(); }

    public List<Event> getAll() { return eventDao.getAll(); }

    public int getEventId(){ return eventId; }

    public void setEventId(int eventId){ this.eventId = eventId; }

    public Event getEvent(){ return event; }

    public void setEvent(Event event){ this.event = event; }

    public int getSubjectId(){ return subjectId; }

    public void setSubjectId(int subjectId){ this.subjectId = subjectId; }

    public Subject getSubject(){ return subject; }

    public void setSubject(Subject subject){ this.subject = subject; }

    public void initEvent(){ event = eventDao.findById(eventId); }

    public String getSelectedSubject(){
        Subject subject = event.getSubject();
        return subject.getName();
    }

    public List<SelectItem> getSubjects(){
        List<Subject> subjects = subjectDao.getAll();
        return subjects.stream().map(s -> new SelectItem(s.getId(), s.getName())).collect(Collectors.toList());
    }

    public List<SelectItem> getTypes(){
        return Arrays.asList(EventType.values()).stream().map(t -> new SelectItem(t, t.name())).collect(Collectors.toList());
    }

    public void persist(){
        Subject subject = subjectDao.findById(subjectId);
        event.setSubject(subject);

        //Set dates too!! and not sure about this?

        eventDao.persist(event);
    }

}
