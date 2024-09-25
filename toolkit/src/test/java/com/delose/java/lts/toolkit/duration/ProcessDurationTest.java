package com.delose.java.lts.toolkit.duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.time.Instant;
import org.junit.jupiter.api.Test;

public class ProcessDurationTest {

    private ProcessDuration processDuration;

    @BeforeEach
    public void setUp() {
        processDuration = new ProcessDuration();
    }

    @Test
    public void givenStartAndEndTimes_whenTestDuration_thenGetDurationValuesAreEqual() {
        //given
        Instant start = Instant.now();
        Instant end = Instant.now();

        //when
        Duration durationBetween = processDuration.getDuration(start, end);

        //then
        Assertions.assertEquals(durationBetween, Duration.between(start, end));
    }

}
