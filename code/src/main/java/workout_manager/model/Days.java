package workout_manager.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Creates a enum for the days of the week
 * 
 * @version Spring 2022
 * @author wtjracer
 */
public enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY;

    public static Date getDate(Date day, String daySelected){
        int dayToFind = Days.stringToEnum(daySelected);
        Calendar calendar = Calendar.getInstance();
        int difference =  dayToFind - calendar.get(Calendar.DAY_OF_WEEK);
        calendar.setTime(day); 
        calendar.add(Calendar.DATE, difference);
        return calendar.getTime();
    }

    public static int stringToEnum(String day){
        if (day.toUpperCase().equals(Days.SUNDAY.toString())) {
            return 1;
        }
        if (day.toUpperCase().equals(Days.MONDAY.toString())) {
            return 2;
        }
        if (day.toUpperCase().equals(Days.TUESDAY.toString())) {
            return 3;
        }
        if (day.toUpperCase().equals(Days.WEDNESDAY.toString())) {
            return 4;
        }
        if (day.toUpperCase().equals(Days.THURSDAY.toString())) {
            return 5;
        }
        if (day.toUpperCase().equals(Days.FRIDAY.toString())) {
            return 6;
        }
        return 7;
    }
}


