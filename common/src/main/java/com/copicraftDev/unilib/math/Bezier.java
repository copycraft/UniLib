package com.copicraftDev.unilib.math;

public class Bezier {
    public static float quadratic(float t, float p0, float p1, float p2) {
        return (1 - t) * (1 - t) * p0 + 2 * (1 - t) * t * p1 + t * t * p2;
    }

    public static float cubic(float t, float p0, float p1, float p2, float p3) {
        return (float) (Math.pow(1 - t, 3) * p0
                + 3 * Math.pow(1 - t, 2) * t * p1
                + 3 * (1 - t) * t * t * p2
                + t * t * t * p3);
    }
}
