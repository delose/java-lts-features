package com.delose.java.lts.toolkit.duration;

import java.time.Duration;
import java.time.Instant;

public class ProcessDuration {

    public Duration getDuration(Instant start, Instant end) {
        return Duration.between(start, end);
    }
}
