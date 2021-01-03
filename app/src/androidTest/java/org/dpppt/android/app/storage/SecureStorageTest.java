package org.dpppt.android.app.storage;

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

public class SecureStorageTest {

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
        DP3T.init(context, new ApplicationInfo("my-app-id",
                        server.url("/bucket/").toString(),
                        server.url("/report/").toString()),
                null);
        // appConfigManager.setTracingEnabled(false);
        // DP3T.clearData(context, () -> {});
        DP3T.init(context, new ApplicationInfo("my-app-id",
                        server.url("/bucket/").toString(),
                        server.url("/report/").toString()),
                null);
        // appConfigManager.setTracingEnabled(true);
    }

    @Test
    public void getAndSetInfectedDate() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setInfectedDate(1000);
        assertEquals(sst.getInfectedDate(), 1000);
    }

    @Test
    public void saveAndClearInformTimeAndCodeAndToken() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.saveInformTimeAndCodeAndToken("iCode", "iToken");
        assertEquals(sst.getLastInformCode(), "iCode");
        assertEquals(sst.getLastInformToken(), "iToken");
        sst.clearInformTimeAndCodeAndToken();
        assertNull(sst.getLastInformCode());
        assertNull(sst.getLastInformToken());
    }

    @Test
    public void getAndSetOnboardingCompleted() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setOnboardingCompleted(false);
        assertFalse(sst.getOnboardingCompleted());
    }

    @Test
    public void getAndSetLastShownContactId() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setLastShownContactId(5000);
        assertEquals(sst.getLastShownContactId(), 5000);
    }

    @Test
    public void getAndSetHotlineCallPending() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setHotlineCallPending(true);
        assertTrue(sst.isHotlineCallPending());
    }

    @Test
    public void getAndSetReportsHeaderAnimationPending() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setReportsHeaderAnimationPending(false);
        assertFalse(sst.isReportsHeaderAnimationPending());
    }

    @Test
    public void getAndSetDoForceUpdate() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setDoForceUpdate(true);
        assertTrue(sst.getDoForceUpdate());
    }

    @Test
    public void getAndSetHasInfobox() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setHasInfobox(false);
        assertFalse(sst.getHasInfobox());
    }

    @Test
    public void getAndSetInfoboxTitle() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setInfoboxTitle("unit test");
        assertEquals(sst.getInfoboxTitle(), "unit test");
    }

    @Test
    public void getAndSetInfoboxText() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setInfoboxText("unit test");
        assertEquals(sst.getInfoboxText(), "unit test");
    }

    @Test
    public void getAndSetForcedTraceShutdown() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setForcedTraceShutdown(false);
        assertFalse(sst.getForcedTraceShutdown());
    }

    @Test
    public void getAndSetInfoboxLinkTitle() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setInfoboxLinkTitle("unit test 3");
        assertEquals(sst.getInfoboxLinkTitle(), "unit test 3");
    }

    @Test
    public void getAndSetInfoboxLinkUrl() {
        SecureStorage sst = SecureStorage.getInstance(context);
        sst.setInfoboxLinkUrl("unit test 5");
        assertEquals(sst.getInfoboxLinkUrl(), "unit test 5");
    }
}