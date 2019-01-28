package com.company.project.helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    private static final DateTimeFormatter UTCDateTimeFormatter = createUTCDateTimeFormatter();
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String PACIFIC_AUCKLAND = "Pacific/Auckland";

    private DateTimeHelper() {
    }

    public static LocalDateTime getLocalDateFromUtc(String dateTime) {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime, UTCDateTimeFormatter);
        return LocalDateTime.ofInstant(zonedDateTime.toInstant(), ZoneId.of(PACIFIC_AUCKLAND));
    }

    private static DateTimeFormatter createUTCDateTimeFormatter() {
        return DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).withZone(ZoneOffset.UTC);
    }

    public static String toFormattedString(LocalDateTime localDateTime) {
        return localDateTime.toString().replace("T", " ");
    }
}
