package org.dpppt.android.app.main.model;

import org.dpppt.android.app.R;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotificationStateTest {

    @Test
    public void getTitle1() {
        int result = NotificationState.getTitle(NotificationState.NO_REPORTS);
        assertEquals(result, R.string.meldungen_no_meldungen_title);
    }

    @Test
    public void getTitle2() {
        int result = NotificationState.getTitle(NotificationState.EXPOSED);
        assertEquals(result, R.string.meldungen_meldung_title);
    }

    @Test
    public void getTitle3() {
        int result = NotificationState.getTitle(NotificationState.POSITIVE_TESTED);
        assertEquals(result, R.string.meldung_homescreen_positiv_title);
    }

    @Test
    public void getText() {
        int result = NotificationState.getText(NotificationState.NO_REPORTS);
        assertEquals(result, R.string.meldungen_no_meldungen_subtitle);
    }

    @Test
    public void getIcon() {
        int result = NotificationState.getIcon(NotificationState.NO_REPORTS);
        assertEquals(result, R.drawable.ic_check);
    }

    @Test
    public void getTitleTextColor() {
        int result = NotificationState.getTitleTextColor(NotificationState.NO_REPORTS);
        assertEquals(result, R.color.green_main);
    }

    @Test
    public void geTextColor() {
        int result = NotificationState.geTextColor(NotificationState.NO_REPORTS);
        assertEquals(result, R.color.dark_main);
    }

    @Test
    public void getBackgroundColor() {
        int result = NotificationState.getBackgroundColor(NotificationState.NO_REPORTS);
        assertEquals(result, R.color.status_green_bg);
    }

    @Test
    public void getIllu() {
        int result = NotificationState.getIllu(NotificationState.NO_REPORTS);
        assertEquals(result, R.drawable.ill_no_message);
    }

}