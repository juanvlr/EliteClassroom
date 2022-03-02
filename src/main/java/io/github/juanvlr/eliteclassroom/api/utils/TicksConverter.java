package io.github.juanvlr.eliteclassroom.api.utils;

public class TicksConverter {

    private static final int TICKS_PER_SECOND = 20;

    public static int minutesToTicks(int minutes) {
        return 60 * minutes * TICKS_PER_SECOND;
    }

    public static int secondsToTicks(int seconds) {
        return seconds * TICKS_PER_SECOND;
    }
}
