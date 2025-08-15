package com.copicraftDev.unilib.math;

public class AngleUtil {
    public static float toRadians(float degrees) { return (float) Math.toRadians(degrees); }
    public static float toDegrees(float radians) { return (float) Math.toDegrees(radians); }
    public static float normalize(float angle) { return (angle % 360 + 360) % 360; }
    public static float shortestPath(float from, float to) {
        float diff = (to - from + 540) % 360 - 180;
        return from + diff;
    }
}
