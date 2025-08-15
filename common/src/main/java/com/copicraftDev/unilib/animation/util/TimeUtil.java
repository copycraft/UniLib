package com.copicraftDev.unilib.animation.util;

public class TimeUtil {

    public static float ticksToSeconds(int ticks) {
        return ticks / 20f;
    }

    public static int secondsToTicks(float seconds) {
        return (int) (seconds * 20f);
    }

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }
}
