package org.sergei._0_core._15_date_time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class DateTimeSamples {
    public static void main(String[] args) {
        /*
        GMT - Greenwich Mean Time
        UTC - Coordinated Universal Time
        DST - Daylight Saving Time
        Sat Mar 18 2017 11:33:49 GMT+0300 (Belarus Standard Time)
         */
        long timestamp = Long.valueOf(1489826038640L);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'kk:mm:ss");

        Stream.of(
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("Z")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("UTC")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("GMT")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("GMT+0300")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("+3")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("America/New_York")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("UTC-4")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("GMT-4")),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("-4"))
        ).forEach(d -> System.out.println(d.format(formatter)));
    }
}
