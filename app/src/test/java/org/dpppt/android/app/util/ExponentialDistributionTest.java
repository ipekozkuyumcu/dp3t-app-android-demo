package org.dpppt.android.app.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExponentialDistributionTest {

    @Test
    public void sampleFromStandard() {
        double result1 = ExponentialDistribution.sampleFromStandard();
        double result2 = ExponentialDistribution.sampleFromStandard();
        assertNotEquals(result1, result2);
    }
}