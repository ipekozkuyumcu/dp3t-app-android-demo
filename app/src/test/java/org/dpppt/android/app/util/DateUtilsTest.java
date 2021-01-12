package org.dpppt.android.app.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void getDaysDiff() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -3);
        int diff = DateUtils.getDaysDiff(calendar.getTimeInMillis());
        assertEquals(diff, 3);
    }

    @Test
    public void getDaysDiffUntil() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -8);
        int diff = DateUtils.getDaysDiffUntil(calendar.getTimeInMillis(), 5);
        assertEquals(diff, -3);
    }

    @Test
    public void getFormattedDateTime() {
        Date dt = new Date(120, 11, 28, 9, 30, 54);

        String diff = DateUtils.getFormattedDateTime(dt.getTime());
        assertEquals(diff, "Dec 28, 2020 9:30:54 AM");
    }

    @Test
    public void getFormattedDate() {
        Date dt = new Date(120, 11, 28);

        String diff = DateUtils.getFormattedDate(dt.getTime());
        assertEquals(diff, "Dec 28, 2020");
    }
}