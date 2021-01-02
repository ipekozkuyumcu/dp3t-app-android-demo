package org.dpppt.android.app.util;

import android.content.Context;
import android.text.SpannableString;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.work.Configuration;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.testing.TestDriver;
import androidx.work.testing.WorkManagerTestInitHelper;

import org.dpppt.android.app.storage.SecureStorage;
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

public class StringUtilTest {


    @Test
    public void makePartiallyBold() {
        SpannableString result = StringUtil.makePartiallyBold("Unit Test Text", 2, 4);
        assertEquals(result.toString(), "Unit Test Text");
    }
}