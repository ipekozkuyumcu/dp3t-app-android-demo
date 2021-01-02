package org.dpppt.android.app.main.model;

import org.dpppt.android.app.R;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotificationStateErrorTest {

    @Test
    public void getTitle() {
        int result = NotificationStateError.getTitle(NotificationStateError.NOTIFICATION_STATE_ERROR);
        assertEquals(result, R.string.meldungen_background_error_title);
    }

    @Test
    public void getText() {
        int result = NotificationStateError.getText(NotificationStateError.NOTIFICATION_STATE_ERROR);
        assertEquals(result, R.string.meldungen_background_error_text);
    }

    @Test
    public void getIcon() {
        int result = NotificationStateError.getIcon(NotificationStateError.NOTIFICATION_STATE_ERROR);
        assertEquals(result, R.drawable.ic_refresh);
    }

    @Test
    public void getButtonText() {
        int result = NotificationStateError.getButtonText(NotificationStateError.NOTIFICATION_STATE_ERROR);
        assertEquals(result, R.string.meldungen_background_error_button);
    }
}