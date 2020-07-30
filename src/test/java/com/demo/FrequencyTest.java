package com.demo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Frequency.class})
public class FrequencyTest {

    private static Calendar calendar =null;

    @BeforeClass
    public static void setup(){
        calendar = Calendar.getInstance();
    }

    @Test
    public void test_2AM_10Min_Freq5_success() {

        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 10);
        mockStatic(Calendar.class);
        when(Calendar.getInstance()).thenReturn(calendar);

        assertTrue(Frequency.executeOnFrequency(5));
    }

    @Test
    public void test_2AM_8Min_Freq5_fail() {

        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 8);
        mockStatic(Calendar.class);
        when(Calendar.getInstance()).thenReturn(calendar);
        assertFalse(Frequency.executeOnFrequency(5));
    }

    @Test
    public void test_1AM_0Min_Freq60_Success() {

        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 0);
        mockStatic(Calendar.class);
        when(Calendar.getInstance()).thenReturn(calendar);
        assertTrue(Frequency.executeOnFrequency(60));
    }

    @Test
    public void test_2AM_0Min_Freq60_Success() {

        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 0);
        mockStatic(Calendar.class);
        when(Calendar.getInstance()).thenReturn(calendar);
        assertTrue(Frequency.executeOnFrequency(60));
    }


    @Test
    public void test_1AM_0Min_Freq75_Fail() {

        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 0);
        mockStatic(Calendar.class);
        when(Calendar.getInstance()).thenReturn(calendar);
        assertFalse(Frequency.executeOnFrequency(75));
    }

    @Test
    public void test_2AM_0Min_Freq40_Success() {

        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE, 0);
        mockStatic(Calendar.class);
        when(Calendar.getInstance()).thenReturn(calendar);
        assertTrue(Frequency.executeOnFrequency(40));
    }


    @Test
    public void test_3AM_0Min_Freq40_Fail() {

        calendar.set(Calendar.HOUR_OF_DAY, 3);
        calendar.set(Calendar.MINUTE, 0);
        mockStatic(Calendar.class);
        when(Calendar.getInstance()).thenReturn(calendar);
        assertFalse(Frequency.executeOnFrequency(40));
    }

}
