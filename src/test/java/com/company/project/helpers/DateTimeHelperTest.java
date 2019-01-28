package com.company.project.helpers;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class DateTimeHelperTest {
    private static final String localDate = "2013-07-10 02:52:49";

    @Test
    public void getLocalDateFromUtcTest() {
        LocalDateTime result = DateTimeHelper.getLocalDateFromUtc(localDate);
        assertEquals(2013, result.getYear());
        assertEquals(07, result.getMonth().getValue());
        assertEquals(10, result.getDayOfMonth());
        assertEquals(14, result.getHour());
        assertEquals(52, result.getMinute());
        assertEquals(49, result.getSecond());
    }

    @Test
    public void toFormattedStringTest() {
        LocalDateTime result = DateTimeHelper.getLocalDateFromUtc(localDate);
        assertEquals("2013-07-10 14:52:49", DateTimeHelper.toFormattedString(result));
    }
}
