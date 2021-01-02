package org.dpppt.android.app.inform.views;

import android.content.Context;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.work.Configuration;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.testing.TestDriver;
import androidx.work.testing.WorkManagerTestInitHelper;

import org.dpppt.android.sdk.DP3T;
import org.dpppt.android.sdk.backend.models.ApplicationInfo;
import org.dpppt.android.sdk.internal.AppConfigManager;
import org.dpppt.android.sdk.internal.logger.LogLevel;
import org.dpppt.android.sdk.internal.logger.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.mockwebserver.MockWebServer;

import static org.junit.Assert.*;

public class ChainedEditTextTest {

    Context context;
    MockWebServer server;
    TestDriver testDriver;

    @Before
    public void setup() throws IOException {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Logger.init(context, LogLevel.DEBUG);

        // Initialize WorkManager for instrumentation tests.
        Configuration config = new Configuration.Builder()
                // Set log level to Log.DEBUG to make it easier to debug
                .setMinimumLoggingLevel(Log.DEBUG)
                .setExecutor(new SynchronousExecutor())
                .build();
        WorkManagerTestInitHelper.initializeTestWorkManager(context, config);

        testDriver = WorkManagerTestInitHelper.getTestDriver(context);

        server = new MockWebServer();
        server.start();

        AppConfigManager appConfigManager = AppConfigManager.getInstance(context);
        DP3T.init(context, new ApplicationInfo("my-app-id", server.url("/bucket/").toString(), server.url("/report/").toString()),
                null);
        // appConfigManager.setTracingEnabled(false);
        // DP3T.clearData(context, () -> {});
        DP3T.init(context, new ApplicationInfo("my-app-id", server.url("/bucket/").toString(), server.url("/report/").toString()),
                null);
        // appConfigManager.setTracingEnabled(true);
    }

    @Test
    public void getTextAndSetText() {
        ChainedEditText cet = new ChainedEditText(context);
        cet.setText("unit test 1");
        assertEquals(cet.getText(), "unit test 1");
    }

    @Test
    public void addAndRemoveTextChangedListener() {
        ChainedEditText.ChainedEditTextListener cetl = new ChainedEditText.ChainedEditTextListener() {
            @Override
            public void onTextChanged(String input) {
                assertEquals(input, "unit test 1");
            }

            @Override
            public void onEditorSendAction() {

            }
        };

        ChainedEditText cet = new ChainedEditText(context);
        cet.addTextChangedListener(cetl);
        cet.setText("unit test 1");
        cet.removeTextChangedListener(cetl);
        cet.setText("unit test 2");
    }

}