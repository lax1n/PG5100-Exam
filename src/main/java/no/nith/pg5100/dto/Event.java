package no.nith.pg5100.dto;

import no.nith.pg5100.dto.constraint.ValidEventDescription;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by August on 12/3/2015.
 */
@Entity
@SecondaryTable(name="event_details")
@NamedQuery(name = "Event.getAll", query = "select e from Event e order by e.startDate desc")
@SequenceGenerator(name = "SEQ_EVENT", initialValue = 50)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVENT")
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EventType type;

    @NotNull
    @Size(min = 5, max = 25)
    private String title;

    @ValidEventDescription
    private String description;

    @NotNull
    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_SUBJECT")
    private Subject subject;

    @NotNull
    @Column(table = "event_details")
    private Date startDate;

    @NotNull
    @Column(table = "event_details")
    private Date endDate;

    public int getId(){ return id; }

    public void setId(int id){ this.id = id; }

    public EventType getType(){ return type; }

    public void setType(EventType type){ this.type = type; }

    public String getTitle(){ return title; }

    public void setTitle(String title){ this.title = title; }

    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }

    public Subject getSubject(){ return subject; }

    public void setSubject(Subject subject){ this.subject = subject; }

    public Date getStartDate(){ return startDate; }

    public void setStartDate(Date startDate){ this.startDate = startDate; }

    public Date getEndDate(){ return endDate; }

    public void setEndDate(Date endDate){ this.endDate = endDate; }

}
