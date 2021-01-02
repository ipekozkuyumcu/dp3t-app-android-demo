package org.dpppt.android.app.main.model;

import org.dpppt.android.app.R;
import org.junit.Test;

import static org.junit.Assert.*;

public class TracingStateTest {

    @Test
    public void getTitle1() {
        int result = TracingState.getTitle(TracingState.ACTIVE);
        assertEquals(result, R.string.tracing_active_title);
    }

    @Test
    public void getTitle2() {
        int result = TracingState.getTitle(TracingState.NOT_ACTIVE);
        assertEquals(result, R.string.tracing_turned_off_title);
    }

    @Test
    public void getTitle3() {
        int result = TracingState.getTitle(TracingState.ENDED);
        assertEquals(result, R.string.tracing_ended_title);
    }

    @Test
    public void getText1() {
        int result = TracingState.getText(TracingState.ACTIVE);
        assertEquals(result, R.string.tracing_active_text);
    }

    @Test
    public void getText2() {
        int result = TracingState.getText(TracingState.NOT_ACTIVE);
        assertEquals(result, R.string.tracing_turned_off_text);
    }

    @Test
    public void getText3() {
        int result = TracingState.getText(TracingState.ENDED);
        assertEquals(result, R.string.tracing_ended_text);
    }

    @Test
    public void getIcon1() {
        int result = TracingState.getIcon(TracingState.ACTIVE);
        assertEquals(result, R.drawable.ic_check);
    }

    @Test
    public void getIcon2() {
        int result = TracingState.getIcon(TracingState.NOT_ACTIVE);
        assertEquals(result, R.drawable.ic_warning_red);
    }

    @Test
    public void getIcon3() {
        int result = TracingState.getIcon(TracingState.ENDED);
        assertEquals(result, R.drawable.ic_stopp);
    }

    @Test
    public void getTextColor1() {
        int result = TracingState.getTextColor(TracingState.ACTIVE);
        assertEquals(result, R.color.blue_main);
    }

    @Test
    public void getTextColor2() {
        int result = TracingState.getTextColor(TracingState.NOT_ACTIVE);
        assertEquals(result, R.color.red_main);
    }

    @Test
    public void getTextColor3() {
        int result = TracingState.getTextColor(TracingState.ENDED);
        assertEquals(result, R.color.purple_main);
    }

    @Test
    public void getBackgroundColor1() {
        int result = TracingState.getBackgroundColor(TracingState.ACTIVE);
        assertEquals(result, R.color.status_blue_bg);
    }

    @Test
    public void getBackgroundColor2() {
        int result = TracingState.getBackgroundColor(TracingState.NOT_ACTIVE);
        assertEquals(result, R.color.grey_dark_lighter);
    }

    @Test
    public void getBackgroundColor3() {
        int result = TracingState.getBackgroundColor(TracingState.ENDED);
        assertEquals(result, R.color.status_purple_bg);
    }

    @Test
    public void getIllu1() {
        int result = TracingState.getIllu(TracingState.ACTIVE);
        assertEquals(result, R.drawable.ill_tracking_active);
    }

    @Test
    public void getIllu2() {
        int result = TracingState.getIllu(TracingState.ENDED);
        assertEquals(result, R.drawable.ic_illu_tracing_ended);
    }

    @Test
    public void getIllu3() {
        int result = TracingState.getIllu(TracingState.NOT_ACTIVE);
        assertEquals(result, -1);
    }
}