package no.nith.pg5100.dto;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by August on 12/5/2015.
 */
public class EventTest {
    private Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void invalidEvent() throws Exception {
        Event event = new Event();
        Set<ConstraintViolation<Event>> violations = validator.validate(event);

        assertEquals(5, violations.size());
    }

    @Test
    public void validEvent() throws Exception {
        Event event = new Event();

        event.setTitle("5-25 Char title!");
        event.setType(EventType.EGENTRENING);

        Subject subject = new Subject();
        subject.setName("Some subject");
        event.setSubject(subject);

        String startDate = "12-12-2015 22:00";
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy HH:mm", Locale.FRANCE);
        event.setStartDate(format.parse(startDate));

        String endDate = "12-12-2015 23:00";
        event.setEndDate(format.parse(endDate));

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertTrue(violations.isEmpty());
    }
}
