package org.dpppt.android.app.util;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void sum() {
        int sum = DateUtils.topla(2, 3);
        assertEquals(sum, 5);
    }

    @Test
    public void getDaysDiff() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -3);
        int diff = DateUtils.getDaysDiff(calendar.getTimeInMillis());
        assertEquals(diff, 3);
    }

    @Test
    public void getDaysDiffUntil() {
    }

    @Test
    public void getFormattedDateTime() {
    }

    @Test
    public void getFormattedDate() {
    }
}