package no.nith.pg5100.infrastructure.event;

import no.nith.pg5100.dto.Event;
import no.nith.pg5100.dto.EventType;
import no.nith.pg5100.dto.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import static org.junit.Assert.*;

/**
 * Created by August on 12/5/2015.
 */
public class JpaEventDaoIT {
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private JpaEventDao eventDao;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("pg5100-lms");
        entityManager = factory.createEntityManager();
        eventDao = new JpaEventDao(entityManager);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        factory.close();
    }

    @Test
    public void persist() throws Exception {
        Event event = new Event();

        event.setTitle("5-25 Char title!");
        event.setType(EventType.FORELESNING);

        Subject subject = new Subject();
        subject.setName("Some subject");
        event.setSubject(subject);

        String startDate = "12-12-2015 22:00";
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy HH:mm", Locale.FRANCE);
        event.setStartDate(format.parse(startDate));

        String endDate = "12-12-2015 23:00";
        event.setEndDate(format.parse(endDate));

        entityManager.getTransaction().begin();
        Event result = eventDao.persist(event);
        entityManager.getTransaction().commit();

        assertTrue(result.getId() > 0);
    }

    @Test
    public void findById() throws Exception {
        Event event = eventDao.findById(1);
        assertEquals("Eksamen", event.getTitle());
    }

    @Test
    public void getAll() throws Exception {
        List<Event> eventList = eventDao.getAll();
        assertEquals(2, eventList.size());
    }
}
