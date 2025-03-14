package net.osslabz.crypto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.Duration;
import java.util.Arrays;
import java.util.Objects;


public enum Interval {

    PT1M(Duration.ofMinutes(1)),
    PT5M(Duration.ofMinutes(5)),
    PT15M(Duration.ofMinutes(15)),
    PT30M(Duration.ofMinutes(30)),
    PT1H(Duration.ofHours(1)),
    PT4H(Duration.ofHours(4)),
    PT12H(Duration.ofHours(12)),
    PT24H(Duration.ofHours(24));

    private final Duration duration;


    Interval(Duration duration) {

        this.duration = duration;
    }


    @JsonIgnore
    public Duration getDuration() {

        return this.duration;
    }


    public static Interval ofDuration(Duration duration) {

        return Arrays.stream(Interval.values()).filter(i -> Objects.equals(duration, i.getDuration())).findAny().orElseThrow();
    }


    public static Interval ofMillis(Long millis) {

        return Arrays.stream(Interval.values()).filter(i -> i.getDuration().toMillis() == millis).findAny().orElseThrow();
    }
}