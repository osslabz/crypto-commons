package net.osslabz.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class IntervalTest {

    @Test
    void findsIntervalByDuration() {
        assertEquals(Interval.PT4H, Interval.ofDuration(Duration.ofHours(4)));
    }

    @Test
    void findsIntervalByMillis() {
        assertEquals(Interval.PT15M, Interval.ofMillis(Duration.ofMinutes(15).toMillis()));
    }

    @Test
    void failsForDurationWithoutInterval() {
        assertThrows(NoSuchElementException.class, () -> Interval.ofDuration(Duration.ofMinutes(2)));
        assertThrows(NoSuchElementException.class, () -> Interval.ofMillis(2L));
    }
}
