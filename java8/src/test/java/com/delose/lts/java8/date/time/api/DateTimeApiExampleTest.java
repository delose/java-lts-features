package com.delose.lts.java8.date.time.api;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class DateTimeApiExampleTest {

    @Test
    public void testFormatDate() {
        DateTimeApiExample example = new DateTimeApiExample();
        LocalDate date = LocalDate.of(2024, 9, 6);

        assertEquals("06-09-2024", example.formatDate(date));
    }

    @Test
    public void testFormatDateTime() {
        DateTimeApiExample example = new DateTimeApiExample();
        LocalDateTime dateTime = LocalDateTime.of(2024, 9, 6, 15, 30, 45);

        assertEquals("06-09-2024 15:30:45", example.formatDateTime(dateTime));
    }

}
