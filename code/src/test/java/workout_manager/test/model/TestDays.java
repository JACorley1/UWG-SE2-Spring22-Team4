package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import workout_manager.model.Days;

public class TestDays {
    
    @Test
    void testGetDate() {
        Date date = new Date();
        date = Days.getDate(date, "Sunday");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        assertEquals(date, cal.getTime());
    }

    @Test
    void testStringToEnum() {
        assertAll(
            () -> assertEquals(1, Days.stringToEnum("Sunday")),
            () -> assertEquals(2, Days.stringToEnum("Monday")),
            () -> assertEquals(3, Days.stringToEnum("Tuesday")),
            () -> assertEquals(4, Days.stringToEnum("Wednesday")),
            () -> assertEquals(5, Days.stringToEnum("Thursday")),
            () -> assertEquals(6, Days.stringToEnum("Friday")),
            () -> assertEquals(7, Days.stringToEnum("Saturday"))
        );
    }
}
