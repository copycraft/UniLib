package com.copicraftDev.unilib.math;

public class Interpolation {
    public static float lerp(float a, float b, float t) { return a + (b - a) * t; }
    public static float inverseLerp(float a, float b, float value) { return (value - a) / (b - a); }
    public static float smoothStep(float a, float b, float t) {
        t = Math.max(0, Math.min(1, (t - a) / (b - a)));
        return t * t * (3 - 2 * t);
    }
}
