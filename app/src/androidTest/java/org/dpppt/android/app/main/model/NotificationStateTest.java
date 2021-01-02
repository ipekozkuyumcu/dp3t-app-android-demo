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
    public void getText1() {
        int result = NotificationState.getText(NotificationState.NO_REPORTS);
        assertEquals(result, R.string.meldungen_no_meldungen_subtitle);
    }

    @Test
    public void getText2() {
        int result = NotificationState.getText(NotificationState.EXPOSED);
        assertEquals(result, R.string.meldungen_meldung_text);
    }

    @Test
    public void getText3() {
        int result = NotificationState.getText(NotificationState.POSITIVE_TESTED);
        assertEquals(result, R.string.meldung_homescreen_positiv_text);
    }

    @Test
    public void getIcon1() {
        int result = NotificationState.getIcon(NotificationState.NO_REPORTS);
        assertEquals(result, R.drawable.ic_check);
    }

    @Test
    public void getIcon2() {
        int result = NotificationState.getIcon(NotificationState.EXPOSED);
        assertEquals(result, R.drawable.ic_info);
    }

    @Test
    public void getIcon3() {
        int result = NotificationState.getIcon(NotificationState.POSITIVE_TESTED);
        assertEquals(result, R.drawable.ic_info);
    }

    @Test
    public void getTitleTextColor1() {
        int result = NotificationState.getTitleTextColor(NotificationState.NO_REPORTS);
        assertEquals(result, R.color.green_main);
    }

    @Test
    public void getTitleTextColor2() {
        int result = NotificationState.getTitleTextColor(NotificationState.EXPOSED);
        assertEquals(result, R.color.white);
    }

    @Test
    public void getTitleTextColor3() {
        int result = NotificationState.getTitleTextColor(NotificationState.POSITIVE_TESTED);
        assertEquals(result, R.color.white);
    }

    @Test
    public void geTextColor1() {
        int result = NotificationState.geTextColor(NotificationState.NO_REPORTS);
        assertEquals(result, R.color.dark_main);
    }

    @Test
    public void geTextColor2() {
        int result = NotificationState.geTextColor(NotificationState.EXPOSED);
        assertEquals(result, R.color.white);
    }

    @Test
    public void geTextColor3() {
        int result = NotificationState.geTextColor(NotificationState.POSITIVE_TESTED);
        assertEquals(result, R.color.white);
    }

    @Test
    public void getBackgroundColor1() {
        int result = NotificationState.getBackgroundColor(NotificationState.NO_REPORTS);
        assertEquals(result, R.color.status_green_bg);
    }

    @Test
    public void getBackgroundColor2() {
        int result = NotificationState.getBackgroundColor(NotificationState.EXPOSED);
        assertEquals(result, R.color.blue_main);
    }

    @Test
    public void getBackgroundColor3() {
        int result = NotificationState.getBackgroundColor(NotificationState.POSITIVE_TESTED);
        assertEquals(result, R.color.purple_main);
    }

    @Test
    public void getIllu1() {
        int result = NotificationState.getIllu(NotificationState.NO_REPORTS);
        assertEquals(result, R.drawable.ill_no_message);
    }

    @Test
    public void getIllu2() {
        int result = NotificationState.getIllu(NotificationState.EXPOSED);
        assertEquals(result, -1);
    }

    @Test
    public void getIllu3() {
        int result = NotificationState.getIllu(NotificationState.POSITIVE_TESTED);
        assertEquals(result, -1);
    }

}