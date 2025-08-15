package com.copicraftDev.unilib.math;

public class SmoothingUtil {
    public static float exponential(float current, float target, float smoothing) {
        return current + (target - current) * smoothing;
    }
}
