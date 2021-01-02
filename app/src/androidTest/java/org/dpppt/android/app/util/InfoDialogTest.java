package org.dpppt.android.app.util;

import android.os.Bundle;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfoDialogTest {

    @Test
    public void newInstance() {
        InfoDialog result = InfoDialog.newInstance(4);
        Bundle bd = result.getArguments();
        assertEquals(bd.getInt("arg_text_id"), 4);
    }

    @Test
    public void newInstanceWithButtonLabel() {
        InfoDialog result = InfoDialog.newInstanceWithButtonLabel(4, 7);
        Bundle bd = result.getArguments();
        assertEquals(bd.getInt("arg_text_id"), 4);
        assertEquals(bd.getInt("arg_button_label_id"), 7);
    }

    @Test
    public void newInstanceWithDetail() {
        InfoDialog result = InfoDialog.newInstanceWithDetail("my title", "my desc");
        Bundle bd = result.getArguments();
        assertEquals(bd.getString("arg_text_string"), "my title");
        assertEquals(bd.getString("ARG_DETAIL_STRING"), "my desc");
    }

    @Test
    public void testNewInstance() {
        InfoDialog result = InfoDialog.newInstance("my title");
        Bundle bd = result.getArguments();
        assertEquals(bd.getString("arg_text_string"), "my title");
    }
}