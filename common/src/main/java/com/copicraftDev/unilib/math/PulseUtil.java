package com.copicraftDev.unilib.math;

public class PulseUtil {
    public static float pulse(float time, float speed) {
        return (float) Math.sin(time * speed) * 0.5f + 0.5f;
    }
}
